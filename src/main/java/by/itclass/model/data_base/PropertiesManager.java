package by.itclass.model.data_base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {
    public static Properties getProperties(String filePath) {//filePath-путь к файлу
        Properties properties = new Properties();
        try (FileReader fileReader = new FileReader(Thread.currentThread()//открываем поток
                .getContextClassLoader()//берем файлы которые относятся к нашему проекту (классы грузит наши), взять контекст класс лоадера(из таргета загружает файлы в память, а файлы лежат в проперти, он знает как достать их)
                .getResource(filePath)//говорим где файл лежит
                .getPath())) {//берем файл расширением properties
            properties.load(fileReader);//сделает объект Properties из файла, считает себе

        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
