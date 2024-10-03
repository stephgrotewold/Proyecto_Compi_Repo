
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package compiler.parser;

import compiler.parser.Lexer;
import java_cup.runtime.Symbol;
import java_cup.runtime.*;
import java.io.FileReader;
import java.io.IOException;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public Parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public Parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\053\000\002\002\004\000\002\002\003\000\002\003" +
    "\007\000\002\004\003\000\002\004\003\000\002\015\004" +
    "\000\002\015\002\000\002\016\003\000\002\016\003\000" +
    "\002\017\005\000\002\005\010\000\002\012\006\000\002" +
    "\012\004\000\002\012\002\000\002\020\005\000\002\021" +
    "\004\000\002\021\002\000\002\022\003\000\002\022\003" +
    "\000\002\023\005\000\002\024\005\000\002\024\003\000" +
    "\002\010\004\000\002\010\007\000\002\010\005\000\002" +
    "\010\003\000\002\025\005\000\002\011\005\000\002\011" +
    "\005\000\002\011\005\000\002\011\003\000\002\011\003" +
    "\000\002\011\006\000\002\011\003\000\002\011\003\000" +
    "\002\011\005\000\002\014\003\000\002\014\002\000\002" +
    "\026\005\000\002\026\003\000\002\007\003\000\002\007" +
    "\003\000\002\007\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\114\000\004\004\006\001\002\000\004\002\116\001" +
    "\002\000\004\002\000\001\002\000\006\026\010\027\007" +
    "\001\002\000\004\017\ufffe\001\002\000\004\017\ufffd\001" +
    "\002\000\004\017\012\001\002\000\012\005\ufffb\006\ufffb" +
    "\007\ufffb\020\ufffb\001\002\000\012\005\023\006\021\007" +
    "\022\020\020\001\002\000\012\005\ufffc\006\ufffc\007\ufffc" +
    "\020\ufffc\001\002\000\012\005\ufff9\006\ufff9\007\ufff9\020" +
    "\ufff9\001\002\000\012\005\ufffa\006\ufffa\007\ufffa\020\ufffa" +
    "\001\002\000\004\026\024\001\002\000\004\002\uffff\001" +
    "\002\000\004\026\uffd8\001\002\000\004\026\uffd7\001\002" +
    "\000\004\026\uffd9\001\002\000\010\016\uffec\021\031\025" +
    "\uffec\001\002\000\006\016\027\025\026\001\002\000\004" +
    "\026\030\001\002\000\012\005\ufff8\006\ufff8\007\ufff8\020" +
    "\ufff8\001\002\000\006\016\uffed\025\uffed\001\002\000\014" +
    "\005\023\006\021\007\022\022\ufff4\025\ufff4\001\002\000" +
    "\006\022\036\025\035\001\002\000\004\026\034\001\002" +
    "\000\006\022\ufff5\025\ufff5\001\002\000\010\005\023\006" +
    "\021\007\022\001\002\000\004\017\037\001\002\000\022" +
    "\005\ufff1\006\ufff1\007\ufff1\012\ufff1\013\ufff1\017\ufff1\020" +
    "\ufff1\026\ufff1\001\002\000\012\005\ufff7\006\ufff7\007\ufff7" +
    "\020\ufff7\001\002\000\022\005\023\006\021\007\022\012" +
    "\045\013\052\017\037\020\053\026\046\001\002\000\004" +
    "\016\113\001\002\000\022\005\ufff2\006\ufff2\007\ufff2\012" +
    "\ufff2\013\ufff2\017\ufff2\020\ufff2\026\ufff2\001\002\000\022" +
    "\005\uffe8\006\uffe8\007\uffe8\012\uffe8\013\uffe8\017\uffe8\020" +
    "\uffe8\026\uffe8\001\002\000\004\021\107\001\002\000\004" +
    "\014\105\001\002\000\022\005\uffef\006\uffef\007\uffef\012" +
    "\uffef\013\uffef\017\uffef\020\uffef\026\uffef\001\002\000\004" +
    "\026\102\001\002\000\022\005\ufff0\006\ufff0\007\ufff0\012" +
    "\ufff0\013\ufff0\017\ufff0\020\ufff0\026\ufff0\001\002\000\014" +
    "\010\055\011\057\021\060\026\054\030\056\001\002\000" +
    "\022\005\ufff3\006\ufff3\007\ufff3\012\ufff3\013\ufff3\017\ufff3" +
    "\020\ufff3\026\ufff3\001\002\000\020\015\uffe3\016\uffe3\021" +
    "\073\022\uffe3\023\uffe3\024\uffe3\025\uffe3\001\002\000\016" +
    "\015\uffe0\016\uffe0\022\uffe0\023\uffe0\024\uffe0\025\uffe0\001" +
    "\002\000\016\015\uffe2\016\uffe2\022\uffe2\023\uffe2\024\uffe2" +
    "\025\uffe2\001\002\000\016\015\uffdf\016\uffdf\022\uffdf\023" +
    "\uffdf\024\uffdf\025\uffdf\001\002\000\014\010\055\011\057" +
    "\021\060\026\054\030\056\001\002\000\012\015\062\016" +
    "\065\023\063\024\064\001\002\000\014\010\055\011\057" +
    "\021\060\026\054\030\056\001\002\000\014\010\055\011" +
    "\057\021\060\026\054\030\056\001\002\000\014\010\055" +
    "\011\057\021\060\026\054\030\056\001\002\000\022\005" +
    "\uffe9\006\uffe9\007\uffe9\012\uffe9\013\uffe9\017\uffe9\020\uffe9" +
    "\026\uffe9\001\002\000\016\015\uffe5\016\uffe5\022\uffe5\023" +
    "\uffe5\024\uffe5\025\uffe5\001\002\000\016\015\uffe6\016\uffe6" +
    "\022\uffe6\023\uffe6\024\uffe6\025\uffe6\001\002\000\016\015" +
    "\uffe4\016\uffe4\022\uffe4\023\063\024\064\025\uffe4\001\002" +
    "\000\012\015\062\022\072\023\063\024\064\001\002\000" +
    "\016\015\uffde\016\uffde\022\uffde\023\uffde\024\uffde\025\uffde" +
    "\001\002\000\016\010\055\011\057\021\060\022\uffdc\026" +
    "\054\030\056\001\002\000\006\022\uffdd\025\100\001\002" +
    "\000\004\022\077\001\002\000\014\015\062\022\uffda\023" +
    "\063\024\064\025\uffda\001\002\000\016\015\uffe1\016\uffe1" +
    "\022\uffe1\023\uffe1\024\uffe1\025\uffe1\001\002\000\014\010" +
    "\055\011\057\021\060\026\054\030\056\001\002\000\014" +
    "\015\062\022\uffdb\023\063\024\064\025\uffdb\001\002\000" +
    "\006\016\uffec\025\uffec\001\002\000\006\016\104\025\026" +
    "\001\002\000\022\005\uffee\006\uffee\007\uffee\012\uffee\013" +
    "\uffee\017\uffee\020\uffee\026\uffee\001\002\000\014\010\055" +
    "\011\057\021\060\026\054\030\056\001\002\000\012\015" +
    "\062\016\uffe7\023\063\024\064\001\002\000\014\010\055" +
    "\011\057\021\060\026\054\030\056\001\002\000\012\015" +
    "\062\022\111\023\063\024\064\001\002\000\004\017\037" +
    "\001\002\000\022\005\uffea\006\uffea\007\uffea\012\uffea\013" +
    "\uffea\017\uffea\020\uffea\026\uffea\001\002\000\022\005\uffeb" +
    "\006\uffeb\007\uffeb\012\uffeb\013\uffeb\017\uffeb\020\uffeb\026" +
    "\uffeb\001\002\000\004\026\115\001\002\000\006\022\ufff6" +
    "\025\ufff6\001\002\000\004\002\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\114\000\006\002\003\003\004\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\004\010\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\015" +
    "\012\001\001\000\012\005\014\007\016\016\013\017\015" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\024\024\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\006\007\032\012\031\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\007\113\001\001\000\004\020\037\001\001\000\004\021" +
    "\040\001\001\000\002\001\001\000\016\007\047\010\046" +
    "\020\043\022\042\023\050\025\041\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\004\024\102\001" +
    "\001\000\002\001\001\000\004\011\060\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\011\070\001\001\000\002" +
    "\001\001\000\004\011\067\001\001\000\004\011\066\001" +
    "\001\000\004\011\065\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\010\011\075\014\074\026\073" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\011\100\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\011\105\001\001\000\002\001\001\000\004" +
    "\011\107\001\001\000\002\001\001\000\004\020\111\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    private Lexer lexer;

    public Parser(Lexer lexer) {
        super();
        this.lexer = lexer;
    }

    public Symbol parse(String filename) throws Exception {
        try {
            lexer = new Lexer(new FileReader(filename));
            return this.parse();
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo: " + e.getMessage());
        }
    }

    @Override
    public Symbol scan() throws Exception {
        return lexer.next_token();
    }

    public void syntax_error(Symbol s) {
        String tokenName = sym.terminalNames[s.sym];
        String tokenValue = s.value == null ? "" : s.value.toString();
        String errorMessage = String.format(
            "Error Sintáctico en la Línea %d, Columna %d: Token '%s' no reconocido. Tipo: %s",
            s.right + 1, s.left + 1, tokenValue, tokenName
        );

        // Imprimir en la consola sin escribir en output.txt
        System.err.println(errorMessage);
    }


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Parser$actions {
  private final Parser parser;

  /** Constructor */
  CUP$Parser$actions(Parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action_part00000000(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Parser$result;

      /* select the action based on the action number */
      switch (CUP$Parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= program EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		RESULT = start_val;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Parser$parser.done_parsing();
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // program ::= class_decl 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("program",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // class_decl ::= CLASS class_name LBRACE class_body_member_list RBRACE 
            {
              Object RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
		Object name = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("class_decl",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // class_name ::= PROGRAM_ID 
            {
              Object RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("class_name",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // class_name ::= ID 
            {
              Object RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("class_name",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // class_body_member_list ::= class_body_member_list class_body_member 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("class_body_member_list",11, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // class_body_member_list ::= 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("class_body_member_list",11, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // class_body_member ::= field_decl 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("class_body_member",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // class_body_member ::= method_decl 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("class_body_member",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // field_decl ::= type id_list SEMI 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("field_decl",13, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // method_decl ::= type ID LPAREN param_list RPAREN block 
            {
              Object RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-4)).value;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("method_decl",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // param_list ::= param_list COMMA type ID 
            {
              Object RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("param_list",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // param_list ::= type ID 
            {
              Object RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("param_list",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // param_list ::= 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("param_list",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // block ::= LBRACE block_item_list RBRACE 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("block",14, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // block_item_list ::= block_item_list block_item 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("block_item_list",15, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // block_item_list ::= 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("block_item_list",15, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // block_item ::= decl 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("block_item",16, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // block_item ::= statement 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("block_item",16, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // decl ::= type id_list SEMI 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("decl",17, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // id_list ::= id_list COMMA ID 
            {
              Object RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("id_list",18, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // id_list ::= ID 
            {
              Object RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("id_list",18, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // statement ::= assignment SEMI 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // statement ::= IF LPAREN expr RPAREN block 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // statement ::= RETURN expr SEMI 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // statement ::= block 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // assignment ::= ID ASSIGN expr 
            {
              Object RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("assignment",19, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // expr ::= expr PLUS expr 
            {
              Object RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Object e1 = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object e2 = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // expr ::= expr MINUS expr 
            {
              Object RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Object e1 = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object e2 = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // expr ::= expr EQ expr 
            {
              Object RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Object e1 = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object e2 = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // expr ::= ID 
            {
              Object RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // expr ::= INT_LITERAL 
            {
              Object RESULT =null;
		int valueleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int valueright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Integer value = (Integer)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // expr ::= ID LPAREN arg_list RPAREN 
            {
              Object RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 33: // expr ::= TRUE 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 34: // expr ::= FALSE 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 35: // expr ::= LPAREN expr RPAREN 
            {
              Object RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object e = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 36: // arg_list ::= arg_list_non_empty 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("arg_list",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 37: // arg_list ::= 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("arg_list",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 38: // arg_list_non_empty ::= arg_list_non_empty COMMA expr 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("arg_list_non_empty",20, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 39: // arg_list_non_empty ::= expr 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("arg_list_non_empty",20, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 40: // type ::= INT 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("type",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 41: // type ::= VOID 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("type",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 42: // type ::= BOOLEAN 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("type",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
              return CUP$Parser$do_action_part00000000(
                               CUP$Parser$act_num,
                               CUP$Parser$parser,
                               CUP$Parser$stack,
                               CUP$Parser$top);
    }
}

}
