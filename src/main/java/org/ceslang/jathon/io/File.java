package org.ceslang.jathon.io;

import static org.ceslang.jathon.builtin.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


/**
 * Jathon File class can help you read, write, or manage your file.
 */
@SuppressWarnings("unused")
public class File
{
    /**
     * The path of bounded file.
     */
    private java.io.File path;

    /**
     * Whether the file is closed. If it is closed, it can be no longer operable.
     */
    private boolean closed;

    /**
     * The open mode of file.
     */
    private mode open_mode;

    /**
     * The mode for file operation.
     */
    public enum mode
    {
        readonly, writeonly, readwrite
    }

    // enum decode {text, binary}

    public File()
    {
        this((java.io.File) null);
    }

    public File(String path)
    {
        this(new java.io.File(path), mode.readonly);
    }

    public File(java.io.File path)
    {
        this(path, mode.readonly);
    }

    public File(String path, mode open_mode)
    {
        this(new java.io.File(path), open_mode);
    }

    public File(java.io.File path, mode open_mode)
    {
        this.closed = false;
        this.path = path;
        this.open_mode = open_mode;
    }


    // helper method

    /**
     * @param input_path The input path of user
     * @return The java {@code File} instance for current java file
     */
    private static File convToJFileStandard(String input_path)
    {
        // TODO Convert relative path to absolute path
        return null;
    }


    /**
     * Open a file by providing {@code String} path. <br>
     * It can be only used when a {@code File} instance does not have pointed to any file.
     */
    public File open(String path)
    {
        return this.open(new java.io.File(path));
    }

    /**
     * Open a file by providing path in {@code java.io.File} form. <br>
     * It can be only used when a {@code File} instance does not have pointed to any file.
     */
    public File open(java.io.File path)
    {
        // TODO Not complete
        if (this.closed)
        {
            printc("0xe9546b", "File is already closed. Raising this error...");
            throw new RuntimeException("Cannot open file after closed.");
        }
        else if (this.path == null)
        {
            this.path = path;
            return this;
        }
        else
        {
            throw new RuntimeException("Already bounded to a file.");
        }
    }

    /**
     * Close a file object, make it no longer able to beu use.<br>
     * If you want to access to a closed file, an exception will raise.
     */
    public void close()
    {
        this.closed = true;
        this.path = null;
        this.open_mode = null;
    }


    /**
     * Check operability of {@code File} instance.<br>
     * If a file is closed, not bounded to other file, or not created yet, it is not operable.
     *
     * @return Whether the file object is still operable
     */
    public boolean isOperable()
    {
        // TODO Not complete
        return !this.closed && this.path != null && this.path.exists() && this.open_mode != null;
    }

    private void check(boolean... require)
    {
        // TODO Not complete
        for (boolean req : require)
        {
            if (!req) { return; }
        }
        if (!this.isOperable())
        {
            throw new RuntimeException("File is not operable.");
        }
    }

    /**
     * Copy existed file to another place.<br>
     * Here is an example:
     *
     * <pre>
     * File copied_file = new File("./file.txt").copyTo("../new path/");
     * </pre>
     *
     * @param target_path The target path of copying
     * @return Newly copied {@code File} instance
     */
    public File copyTo(String target_path)
    {
        return this.copyTo(new java.io.File(target_path), target_path.endsWith("/") || target_path.endsWith("\\"));
    }

    /**
     * <b>Caution</b>: If you are coping files to a uncreated directory, DO NOT use it. <br>
     * use {@link File#copyTo(String)} instead.
     *
     * @param target_path The target path of copying
     * @return Newly copied {@code File} instance
     */
    public File copyTo(java.io.File target_path)
    {
        return this.copyTo(target_path, target_path.isDirectory());
    }

    private File copyTo(java.io.File target_path, boolean is_dir)
    {
        // TODO Relative path problem - Java is from project's root. Use $ for project root
        try
        {
            if (!target_path.exists())
            {
                boolean $ = is_dir ? target_path.mkdirs() : target_path.createNewFile();
            }

            Files.copy(this.path.toPath(), Paths.get(target_path + "/" + (is_dir ? this.path.getName() : "")),
                       StandardCopyOption.REPLACE_EXISTING);

            this.path = target_path;

            if (!this.path.exists())
            {
                throw new RuntimeException("Copied but copied file is missing.");
            }

        }
        catch (IOException e)
        {
            throw new RuntimeException("System does not complete copying job.", e);
        }

        return this;
    }

    /**
     * Move existed file to another place.<br>
     * Here is an example:
     *
     * <pre>
     * File moved_file = new File("./file.txt").moveTo("../new path/");
     * </pre>
     *
     * @param target_path The target path of moving
     * @return Newly moved {@code File} instance
     */
    public File moveTo(String target_path)
    {
        return this.moveTo(new java.io.File(target_path), target_path.endsWith("/") || target_path.endsWith("\\"));
    }

    /**
     * <b>Caution</b>: If you are moving files to a uncreated directory, DO NOT use it. <br>
     * use {@link File#moveTo(String)} instead.
     *
     * @param target_path The target path of moving
     * @return Newly moved {@code File} instance
     */
    public File moveTo(java.io.File target_path)
    {
        return this.copyTo(target_path, target_path.isDirectory());
    }

    private File moveTo(java.io.File target_path, boolean is_dir)
    {
        try
        {
            if (!target_path.exists())
            {
                boolean $ = is_dir ? target_path.mkdirs() : target_path.createNewFile();
            }

            Files.move(this.path.toPath(), Paths.get(target_path + "/" + (is_dir ? this.path.getName() : "")),
                       StandardCopyOption.REPLACE_EXISTING);

            this.path = target_path;

            if (!this.path.exists())
            {
                throw new RuntimeException("Moved but moved file is missing.");
            }

        }
        catch (IOException e)
        {
            throw new RuntimeException("System does not complete moving job.", e);
        }

        return this;
    }

    public void create()
    {
        // TODO Not complete
    }

    public void delete()
    {
        // TODO Not complete
    }

    public File setPermission()
    {
        // TODO Not complete
        return null;
    }

    public boolean isExisted()
    {
        // TODO Not complete
        return false;
    }

    public boolean isSameFileTo(String file_path)
    {
        try
        {
            return Files.isSameFile(this.path.toPath(), new java.io.File(file_path).toPath());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return false;
    }

    public boolean isReadable()
    {
        check();
        return Files.isReadable(this.path.toPath()) && this.open_mode != mode.writeonly;
    }

    public static boolean isReadableFile(File file)
    {
        file.check();
        return file.isReadable();
    }

    public boolean isWriteable()
    {
        check();
        return Files.isWritable(this.path.toPath()) && this.open_mode != mode.readonly;
    }

    public boolean isReadwriteable()
    {
        check();
        return this.isReadable() && this.isWriteable();
    }

    public boolean isExecutable()
    {
        check();
        return Files.isExecutable(this.path.toPath());
    }

    public String fileAbsolutePath()
    {
        check();
        try
        {
            return this.path.getCanonicalPath();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public String fileAbsolutePath(String separator)
    {
        check();
        // TODO Not complete
        try
        {
            return this.path.getCanonicalPath()
                .replaceAll(System.getProperty("file.separator").replaceAll("\\\\", "\\\\\\\\"), separator);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public String fileRelativePath()
    {
        check();
        return this.path.toString();
    }

    public String fileRelativePath(String separator)
    {
        // TODO Not complete
        check();
        return this.fileRelativePath().replaceAll(System.getProperty("file.separator").replaceAll("\\\\", "\\\\\\\\"),
                                                  separator);
    }

    public long fileSize()
    {
        check();
        try
        {
            return Files.size(this.path.toPath());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return -1;
    }

    public java.io.File getJavaFileObj()
    {
        check();
        return this.path;
    }

    // Start of file itself read/write operation

    public File seek(long to)
    {
        // TODO Not complete
        check();
        return null;
    }

    public File seek(long offset, long from)
    {
        // TODO Not complete
        check();
        return null;
    }

    public String read()
    {
        // TODO Not complete
        check(this.isReadable());
        return null;
    }

    public String[] readAllLines()
    {
        // TODO Not complete
        check();
        try
        {
            return Files.readAllLines(this.path.toPath()).toArray(new String[]{});
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public File write(String content)
    {
        // TODO Not complete
        check();
        return this;
    }

    public File append(String content)
    {
        // TODO Not complete
        check();
        return this;
    }

    public Iterator<String> iterLines()
    {
        // TODO Not complete
        check();
        try
        {
            Scanner s = new Scanner(this.path.toPath());
            return new Iterator<>()
            {
                @Override
                public boolean hasNext()
                {
                    return s.hasNext();
                }

                @Override
                public String next()
                {
                    return s.nextLine();
                }
            };
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String toString()
    {
        // TODO Not complete
        check();
        final StringBuilder ret = new StringBuilder("Jathon File Object\n");
        ret.append("Name: ").append(this.path.getName()).append("\n");
        ret.append("Path: ").append(this.path.getPath());

        return ret.toString();
    }
}