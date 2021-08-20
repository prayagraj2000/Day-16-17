package lists.arrayLists.unorderedList;

import lists.arrayLists.List;
import java.lang.IndexOutOfBoundsException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Unordered<T> implements List<T>, Iterable<T>
{
    private static int MAX_SIZE = 100;
    private int size;
    private Node<T>[] nodeElements;

    public UnorderedList()
    {
        nodeElements = new Node[MAX_SIZE];
    }

    public UnorderedList(int capacity)
    {
        MAX_SIZE = capacity;
        nodeElements = new Node[MAX_SIZE];
    }

    @Override
    public boolean isFull()
    {
        return (size() == MAX_SIZE);
    }

    @Override
    public boolean isEmpty()
    {
        return (size() == 0);
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public boolean add(T data)
    {
        try
        {
            Node<T> node = new Node<>(data);
            nodeElements[size++] = node;
            return true;
        }
        catch (IndexOutOfBoundsException ex)
        {
            System.out.println(ex.getMessage());
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void remove(T data)
    {
        int index = locate(data);
        try
        {
            nodeElements[index] = nodeElements[size() - 1];
            size--;
        }
        catch (IndexOutOfBoundsException ex)
        {
            throw new NoSuchElementException();
        }
    }

    @Override
    public boolean find(T data)
    {
        return (locate(data) >= 0);
    }

    private int locate(T data)
    {
        for (int index = 0; index < size(); index++)
        {
            if (data == nodeElements[index].getData())
            {
                return index;
            }
        }
        return - 1;
    }

    @Override
    public Iterator<T> iterator()
    {
        return new ULIterator<T>();
    }

    private class ULIterator<T> implements Iterator<T>
    {
        private int currentIndex = 0;

        @Override
        public boolean hasNext()
        {
            return (currentIndex < size());
        }

        @Override
        public T next()
        {
            if(hasNext())
            {
                return (T)nodeElements[currentIndex++].getData();
            }
            else
            {
                throw new NoSuchElementException();
            }
        }
    }
}
