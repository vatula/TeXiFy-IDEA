// This is a generated file. Not intended for manual editing.
package nl.rubensten.texifyidea.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static nl.rubensten.texifyidea.psi.BibtexTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class BibtexParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == BRACED_STRING) {
      r = braced_string(b, 0);
    }
    else if (t == COMMENT) {
      r = comment(b, 0);
    }
    else if (t == CONTENT) {
      r = content(b, 0);
    }
    else if (t == DEFINED_STRING) {
      r = defined_string(b, 0);
    }
    else if (t == ENTRY) {
      r = entry(b, 0);
    }
    else if (t == ID) {
      r = id(b, 0);
    }
    else if (t == KEY) {
      r = key(b, 0);
    }
    else if (t == PREAMBLE) {
      r = preamble(b, 0);
    }
    else if (t == QUOTED_STRING) {
      r = quoted_string(b, 0);
    }
    else if (t == STRING) {
      r = string(b, 0);
    }
    else if (t == TAG) {
      r = tag(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return bibtexFile(b, l + 1);
  }

  /* ********************************************************** */
  // (entry | comment)* SEPARATOR?
  static boolean bibtexFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bibtexFile")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bibtexFile_0(b, l + 1);
    r = r && bibtexFile_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (entry | comment)*
  private static boolean bibtexFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bibtexFile_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!bibtexFile_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bibtexFile_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // entry | comment
  private static boolean bibtexFile_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bibtexFile_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = entry(b, l + 1);
    if (!r) r = comment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SEPARATOR?
  private static boolean bibtexFile_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bibtexFile_1")) return false;
    consumeToken(b, SEPARATOR);
    return true;
  }

  /* ********************************************************** */
  // OPEN_BRACE NORMAL_TEXT+ CLOSE_BRACE
  public static boolean braced_string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "braced_string")) return false;
    if (!nextTokenIs(b, OPEN_BRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_BRACE);
    r = r && braced_string_1(b, l + 1);
    r = r && consumeToken(b, CLOSE_BRACE);
    exit_section_(b, m, BRACED_STRING, r);
    return r;
  }

  // NORMAL_TEXT+
  private static boolean braced_string_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "braced_string_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NORMAL_TEXT);
    int c = current_position_(b);
    while (r) {
      if (!consumeToken(b, NORMAL_TEXT)) break;
      if (!empty_element_parsed_guard_(b, "braced_string_1", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // COMMENT_TOKEN
  public static boolean comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comment")) return false;
    if (!nextTokenIs(b, COMMENT_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMENT_TOKEN);
    exit_section_(b, m, COMMENT, r);
    return r;
  }

  /* ********************************************************** */
  // (string (CONCATENATE string)+) | string | NUMBER | IDENTIFIER
  public static boolean content(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "content")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONTENT, "<content>");
    r = content_0(b, l + 1);
    if (!r) r = string(b, l + 1);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // string (CONCATENATE string)+
  private static boolean content_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "content_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = string(b, l + 1);
    r = r && content_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (CONCATENATE string)+
  private static boolean content_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "content_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = content_0_1_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!content_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "content_0_1", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // CONCATENATE string
  private static boolean content_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "content_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONCATENATE);
    r = r && string(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean defined_string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "defined_string")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, DEFINED_STRING, r);
    return r;
  }

  /* ********************************************************** */
  // SEPARATOR? TYPE_TOKEN OPEN_BRACE ((id? (tag SEPARATOR)* tag ENDTRY) | preamble CLOSE_BRACE)
  public static boolean entry(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entry")) return false;
    if (!nextTokenIs(b, "<entry>", SEPARATOR, TYPE_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENTRY, "<entry>");
    r = entry_0(b, l + 1);
    r = r && consumeTokens(b, 0, TYPE_TOKEN, OPEN_BRACE);
    r = r && entry_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SEPARATOR?
  private static boolean entry_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entry_0")) return false;
    consumeToken(b, SEPARATOR);
    return true;
  }

  // (id? (tag SEPARATOR)* tag ENDTRY) | preamble CLOSE_BRACE
  private static boolean entry_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entry_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = entry_3_0(b, l + 1);
    if (!r) r = entry_3_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // id? (tag SEPARATOR)* tag ENDTRY
  private static boolean entry_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entry_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = entry_3_0_0(b, l + 1);
    r = r && entry_3_0_1(b, l + 1);
    r = r && tag(b, l + 1);
    r = r && consumeToken(b, ENDTRY);
    exit_section_(b, m, null, r);
    return r;
  }

  // id?
  private static boolean entry_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entry_3_0_0")) return false;
    id(b, l + 1);
    return true;
  }

  // (tag SEPARATOR)*
  private static boolean entry_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entry_3_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!entry_3_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "entry_3_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // tag SEPARATOR
  private static boolean entry_3_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entry_3_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tag(b, l + 1);
    r = r && consumeToken(b, SEPARATOR);
    exit_section_(b, m, null, r);
    return r;
  }

  // preamble CLOSE_BRACE
  private static boolean entry_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entry_3_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = preamble(b, l + 1);
    r = r && consumeToken(b, CLOSE_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // comment* IDENTIFIER comment* SEPARATOR
  public static boolean id(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id")) return false;
    if (!nextTokenIs(b, "<id>", COMMENT_TOKEN, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ID, "<id>");
    r = id_0(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && id_2(b, l + 1);
    r = r && consumeToken(b, SEPARATOR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // comment*
  private static boolean id_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!comment(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "id_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // comment*
  private static boolean id_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!comment(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "id_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, KEY, r);
    return r;
  }

  /* ********************************************************** */
  // (quoted_string (CONCATENATE quoted_string)+) | quoted_string | NUMBER | IDENTIFIER
  public static boolean preamble(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "preamble")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PREAMBLE, "<preamble>");
    r = preamble_0(b, l + 1);
    if (!r) r = quoted_string(b, l + 1);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // quoted_string (CONCATENATE quoted_string)+
  private static boolean preamble_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "preamble_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = quoted_string(b, l + 1);
    r = r && preamble_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (CONCATENATE quoted_string)+
  private static boolean preamble_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "preamble_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = preamble_0_1_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!preamble_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "preamble_0_1", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // CONCATENATE quoted_string
  private static boolean preamble_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "preamble_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONCATENATE);
    r = r && quoted_string(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // QUOTES NORMAL_TEXT QUOTES
  public static boolean quoted_string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quoted_string")) return false;
    if (!nextTokenIs(b, QUOTES)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, QUOTES, NORMAL_TEXT, QUOTES);
    exit_section_(b, m, QUOTED_STRING, r);
    return r;
  }

  /* ********************************************************** */
  // defined_string | quoted_string | braced_string
  public static boolean string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRING, "<string>");
    r = defined_string(b, l + 1);
    if (!r) r = quoted_string(b, l + 1);
    if (!r) r = braced_string(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // comment* key comment* ASSIGNMENT comment* content comment*
  public static boolean tag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag")) return false;
    if (!nextTokenIs(b, "<tag>", COMMENT_TOKEN, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TAG, "<tag>");
    r = tag_0(b, l + 1);
    r = r && key(b, l + 1);
    r = r && tag_2(b, l + 1);
    r = r && consumeToken(b, ASSIGNMENT);
    r = r && tag_4(b, l + 1);
    r = r && content(b, l + 1);
    r = r && tag_6(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // comment*
  private static boolean tag_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!comment(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tag_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // comment*
  private static boolean tag_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!comment(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tag_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // comment*
  private static boolean tag_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag_4")) return false;
    int c = current_position_(b);
    while (true) {
      if (!comment(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tag_4", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // comment*
  private static boolean tag_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag_6")) return false;
    int c = current_position_(b);
    while (true) {
      if (!comment(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tag_6", c)) break;
      c = current_position_(b);
    }
    return true;
  }

}