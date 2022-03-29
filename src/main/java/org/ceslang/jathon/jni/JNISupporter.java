package org.ceslang.jathon.jni;

import org.ceslang.jathon.builtin;

import java.io.*;

import static org.ceslang.jathon.builtin.*;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class JNISupporter
{
    private JNISupporter()
    {

    }

    /**
     * @param jni_lib_path Absolute path in JAR <b>without</b> "/"
     * @return lib name for {@link System#load}
     */
    public static String prepare(String jni_lib_path)
    {
        String file_name;
        StringBuilder lib_name = new StringBuilder();
        {
            String[] paths = jni_lib_path.split("/");
            file_name = "org_ceslang_jathon_" + paths[paths.length - 1];
            String[] names = file_name.split("\\.");
            for (int i = 0; i < names.length - 1; i++)
            {
                lib_name.append(names[i]).append(i != names.length - 2 ? "." : "");
            }
        }

        JNISupporter.extractFromJar(jni_lib_path, file_name);

        return lib_name.toString();
    }

    /**
     * @param in_jar_path File to extract, use absolute path from jar root dir
     * @param file_name   The file name of will extract file
     * @return Extracted file's absolute path
     */
    private static String extractFromJar(String in_jar_path, String file_name)
    {
        String extract_location = System.getenv("JAVA_HOME") + "/bin/" + file_name;
        File temp = new File(extract_location);
        try
        {
            if (!temp.createNewFile())
            {
                temp.delete();
                temp.createNewFile();
            }

            InputStream in_jar_file_stream = builtin.class.getResourceAsStream(in_jar_path);
            OutputStream extract_output_stream = new FileOutputStream(extract_location);
            byte[] buffer = new byte[1024];
            int byte_already_read;

            assert in_jar_file_stream != null;
            while ((byte_already_read = in_jar_file_stream.read(buffer)) != -1)
            {
                extract_output_stream.write(buffer, 0, byte_already_read);
            }

            extract_output_stream.flush();
            in_jar_file_stream.close();
            extract_output_stream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return extract_location;
    }
}