package mytest;

import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

class Person {
    private long id;
    private String name;
    private List<String> books;

    public Person(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(long id, String name, List<String> books) {
        this(id, name);
        this.books = books;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }

    @Override
    public String toString(){
        return "Person : { id=" + this.id + "  name=" + this.name + "  books=" + this.books + " }";
    }
}

public class Gsontest {
    static Gson gson = new Gson();

    public static void main(String[] args) {
        toJson();
        fromJson();
    }

    static void toJson() {
        List<String> books = new LinkedList<String>();
        books.add("abook");
        books.add("bbook");
        books.add("cbook");
        Person person = new Person(1, "xiao", books);

        // 将一个对象转为以键值对表示的字符串,对象内可包含list等都可以
        String ps = gson.toJson(person);
        System.out.println(ps);

        // 将一个对象List 转为以键值对表示的字符串
        List<Person> persons = new LinkedList<Person>();
        persons.add(person);
        persons.add(new Person(2, "ming", books));
        System.out.println(gson.toJson(persons));
    }

    static void fromJson() {
        // 空字符串转出来对象为null
        String json = "";
        // 提供两个参数，分别是json字符串以及需要转换对象的类型。
        Person person = gson.fromJson(json, Person.class);
        System.out.println(person);

        // 注:字符串必须在{}内,list类型包含在[]内,否则转换失败抛异常
        json = "{}";
        // {}内无内容,可以转换成对象,对象不为空,但是各个字段没有值
        person = gson.fromJson(json, Person.class);
        System.out.println(person);

        // 注意键值对的写法,如果转换出错,很可能是写法不对,写法可以参照由 toJson 转出来的字符串.
        json = "{\"id\":2,\"name\":\"abc\",\"books\":[\"xiqu\",\"wenzhang\",\"xiaoshuo\"]}";
        person = gson.fromJson(json, Person.class);
        System.out.println(person);

        // TypeToken，它是gson提供的数据类型转换器，可以支持各种数据集合类型转换
        json = "[{\"id\":2,\"name\":\"abc\",\"books\":[\"xiqu\",\"wenzhang\",\"xiaoshuo\"]},"
                + "{\"id\":3,\"name\":\"def\",\"books\":[\"dianshi\",\"wenzhang\",\"xiaoshuo\"]}]";
        List<Person> persons = gson.fromJson(json, new TypeToken<List<Person>>() {
        }.getType());
        System.out.println(persons);
    }
}
