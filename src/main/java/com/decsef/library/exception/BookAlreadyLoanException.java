package com.decsef.library.exception;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class BookAlreadyLoanException extends RuntimeException{

    public BookAlreadyLoanException(String... searchParamsMap) {
        super(BookAlreadyLoanException.generateMessage(toMap(String.class, String.class, searchParamsMap)));
    }

    private static String generateMessage(Map<String, String> searchParams) {
        return " The book= " +
                searchParams.get("bookTittle")+
                ", already loan to the student= "+
                searchParams.get("studentName");
    }

    private static <K, V> Map<K, V> toMap(
            Class<K> keyType, Class<V> valueType, Object... entries) {
        if (entries.length % 2 == 1)
            throw new IllegalArgumentException("Invalid entries");
        return IntStream.range(0, entries.length / 2).map(i -> i * 2)
                .collect(HashMap::new,
                        (m, i) -> m.put(keyType.cast(entries[i]), valueType.cast(entries[i + 1])),
                        Map::putAll);
    }
}
