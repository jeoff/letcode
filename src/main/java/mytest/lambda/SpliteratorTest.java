package mytest.lambda;

import lombok.Data;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpliteratorTest {

    @Test
    public void givenSpliterator_whenAppliedToAListOfArticle_thenSplittedInHalf() {
        List list = Stream.generate(() -> new Article("Java"))
                .limit(35001)
                .collect(Collectors.toList());
        Spliterator<Article> split1 = list.spliterator();
        Spliterator<Article> split2 = split1.trySplit();

        Assert.assertEquals(17501, split1.estimateSize());
        Assert.assertEquals(17500, split2.estimateSize());

        Function<String, Article> customConstructor = name -> {
            String[] arr = name.split(";;");
            Article article = new Article(arr[0]);
            article.setId(Integer.parseInt(arr[1]));
            return article;
        };

        System.out.println(Arrays.asList("Tom;;20", "Jerry;;23", "Harry;;30").stream()
                .map(customConstructor)
                .collect(Collectors.toMap(Article::getName, Function.identity())));

    }
}

@Data
class Article {
    private List<String> listOfAuthors;
    private int id;
    private String name;

    public Article(String name) {
        this.name = name;
    }
}


