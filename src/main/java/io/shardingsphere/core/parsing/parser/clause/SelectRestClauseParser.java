package io.shardingsphere.core.parsing.parser.clause;

import io.shardingsphere.core.parsing.lexer.LexerEngine;
import io.shardingsphere.core.parsing.lexer.token.DefaultKeyword;
import io.shardingsphere.core.parsing.lexer.token.Keyword;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

/**
 * @author gouqi
 */
@RequiredArgsConstructor
public abstract class SelectRestClauseParser implements SQLClauseParser {

    private final LexerEngine lexerEngine;

    /**
     * Parse select rest.
     */
    public final void parse() {
        Collection<Keyword> unsupportedRestKeywords = new LinkedList<>();
        //删除了 DefaultKeyword.UNION 未测试. 若有BUG建议添加回去
        unsupportedRestKeywords.addAll(Arrays.asList(DefaultKeyword.INTERSECT, DefaultKeyword.EXCEPT, DefaultKeyword.MINUS));
        unsupportedRestKeywords.addAll(Arrays.asList(getUnsupportedKeywordsRest()));
        lexerEngine.unsupportedIfEqual(unsupportedRestKeywords.toArray(new Keyword[unsupportedRestKeywords.size()]));
    }

    protected abstract Keyword[] getUnsupportedKeywordsRest();
}

