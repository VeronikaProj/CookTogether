package Listeners;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Ника on 20.03.2017.
 */
@WebListener

public class dbInitializer implements ServletContextListener {

        @Resource(name = "jdbc/TestDB")
        private DataSource dataSource;

    //private static final Logger logger = LogManager.getLogger(dbInitializer.class.getName());

        @Override
        public void contextInitialized(ServletContextEvent sce) {
            //logger.info("Server starting");
            Pattern pattern = Pattern.compile("^\\d+\\.sql$");
            Path sqlDirPath = Paths.get(
                    //sce.getServletContext().getRealPath("/WEB-INF/classes/Sql/h2"));
                    sce.getServletContext().getRealPath("/WEB-INF/classes/Sql/h2"));

            try (Connection connection = dataSource.getConnection();
                 Statement statement = connection.createStatement();
                 DirectoryStream<Path> paths = Files.newDirectoryStream(sqlDirPath)) {
                for (Path filePath : paths)
                    if (pattern.matcher(filePath.toFile().getName()).find()) {
                        statement.addBatch(
                                Files.lines(filePath)
                                        .collect(Collectors.joining())
                        );
                    }
                statement.executeBatch(); // this.getClass().getResourceAsStream("/Sql")
            }
            catch(SQLException e){
                //logger.error("Sql connection failed. Can't find db"+dataSource.toString());
            }
            catch (IOException e){
                //logger.error("Files with Sql script wasn't found in "+sqlDirPath.toString());
        }
    }

}
