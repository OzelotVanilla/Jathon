package org.ceslang.jathon.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.Scanner;


/**
 * Jathon File class can help you read, write, or manage your file.
 */
@SuppressWarnings("unused")
public class File
{
    private java.io.File path;
    private mode operation_mode;

    /**
     * The mode for file operation.
     */
    public enum mode
    {readonly, writeonly, readwrite, append}

    // enum decode {text, binary}

    public File()
    {
        // TODO Not complete
    }

    public File(String path)
    {
        // TODO Not complete
        this.path = new java.io.File(path);
    }

    public File(java.io.File path)
    {
        // TODO Not complete
        this.path = path;
    }


    /**
     * Open a file by providing String path. <br>
     * It can be only used when a File instance does not have pointed to any file.
     */
    public File open(String path)
    {
        // TODO Not complete
        return null;
    }

    /**
     * Open a file by providing path in java.io.File form. <br>
     * It can be only used when a File instance does not have pointed to any file.
     */
    public File open(java.io.File path)
    {
        // TODO Not complete
        return null;
    }

    /**
     * Close a file object, make it not operable.
     */
    public void close()
    {
        // TODO Not complete
    }


    /**
     * @return Whether the file object is still operable
     */
    public boolean isOperable()
    {
        // TODO Not complete
        return path.exists();
    }

    public File copyTo(String target_path)
    {
        // TODO Not complete
        return null;
    }

    public File moveTo(String target_path)
    {
        // TODO Not complete
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
        return Files.isReadable(this.path.toPath());
    }

    public boolean isWriteable()
    {
        return Files.isWritable(this.path.toPath());
    }

    public boolean isReadwriteable()
    {
        return Files.isReadable(this.path.toPath()) && Files.isWritable(this.path.toPath());
    }

    public boolean isExecutable()
    {
        return Files.isExecutable(this.path.toPath());
    }

    public String fileAddress()
    {
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

    public long fileSize()
    {
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

    public String filePathStr()
    {
        return this.path.toString();
    }

    public java.io.File getJavaFileObj()
    {
        return this.path;
    }

    // Start of file itself read/write operation

    public File seek(long to)
    {
        // TODO Not complete
        return null;
    }

    public File seek(long offset, long from)
    {
        // TODO Not complete
        return null;
    }

    public String read()
    {
        // TODO Not complete
        return null;
    }

    public String[] readAllLines()
    {
        // TODO Not complete
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
        return this;
    }

    public File append(String content)
    {
        // TODO Not complete
        return this;
    }

    public Iterator<String> iterLines()
    {
        // TODO Not complete
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
        final StringBuilder ret = new StringBuilder("Jathon File Object\n");
        ret.append("Name: ").append(this.path.getName()).append("\n");
        ret.append("Path: ").append(this.path.getPath());

        return ret.toString();
    }
}