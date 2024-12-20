// DO NOT EDIT
// Generated by JFlex 1.9.1 http://jflex.de/
// source: classes/compiler/lexer/Lexer.flex

package compiler.lexer;

import java_cup.runtime.*;
import compiler.parser.sym;


@SuppressWarnings("fallthrough")
public class Lexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\37\u0100\1\u0200\267\u0100\10\u0300\u1020\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\1\2\2\3\1\4\22\0\1\1\1\5"+
    "\1\6\2\0\1\7\1\10\1\11\1\12\1\13\1\14"+
    "\1\15\1\16\1\17\1\0\1\20\1\21\11\22\1\0"+
    "\1\23\1\24\1\25\1\26\2\0\6\27\11\30\1\31"+
    "\12\30\1\32\1\33\1\34\1\0\1\35\1\0\1\36"+
    "\1\37\1\40\1\41\1\42\1\43\1\44\1\30\1\45"+
    "\1\30\1\46\1\47\1\50\1\51\1\52\2\30\1\53"+
    "\1\54\1\55\1\56\1\57\1\30\1\60\2\30\1\61"+
    "\1\62\1\63\7\0\1\3\u01a2\0\2\3\326\0\u0100\3";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1024];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\1\1\4\2\1\1\5"+
    "\1\6\1\7\1\10\1\11\1\12\1\13\2\14\1\15"+
    "\1\16\1\17\1\20\2\21\1\22\1\23\10\21\1\24"+
    "\1\1\1\25\1\26\1\0\1\27\1\30\2\0\1\31"+
    "\1\32\1\0\1\33\1\0\1\34\1\35\1\36\11\21"+
    "\1\37\4\21\1\40\2\41\2\0\1\42\10\21\1\43"+
    "\1\44\3\21\1\45\1\46\6\21\1\47\2\21\1\50"+
    "\1\51\2\21\1\52\1\21\1\53\1\21\1\54\5\21"+
    "\1\55\1\56\1\57\1\60\1\21\1\61";

  private static int [] zzUnpackAction() {
    int [] result = new int[114];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\64\0\150\0\234\0\320\0\64\0\u0104\0\u0138"+
    "\0\64\0\64\0\64\0\u016c\0\64\0\u01a0\0\u01d4\0\u0208"+
    "\0\u023c\0\64\0\u0270\0\u02a4\0\u02d8\0\u030c\0\u0340\0\64"+
    "\0\64\0\u0374\0\u03a8\0\u03dc\0\u0410\0\u0444\0\u0478\0\u04ac"+
    "\0\u04e0\0\64\0\u0514\0\64\0\64\0\320\0\64\0\64"+
    "\0\u0548\0\u057c\0\64\0\64\0\u05b0\0\u05e4\0\u0618\0\64"+
    "\0\64\0\64\0\u064c\0\u0680\0\u06b4\0\u06e8\0\u071c\0\u0750"+
    "\0\u0784\0\u07b8\0\u07ec\0\u030c\0\u0820\0\u0854\0\u0888\0\u08bc"+
    "\0\64\0\64\0\u08f0\0\u08f0\0\u0924\0\u0618\0\u0958\0\u098c"+
    "\0\u09c0\0\u09f4\0\u0a28\0\u0a5c\0\u0a90\0\u0ac4\0\u030c\0\u030c"+
    "\0\u0af8\0\u0b2c\0\u0b60\0\64\0\64\0\u0b94\0\u0bc8\0\u0bfc"+
    "\0\u0c30\0\u0c64\0\u0c98\0\u030c\0\u0ccc\0\u0d00\0\u030c\0\u030c"+
    "\0\u0d34\0\u0d68\0\u030c\0\u0d9c\0\u030c\0\u0dd0\0\u030c\0\u0e04"+
    "\0\u0e38\0\u0e6c\0\u0ea0\0\u0ed4\0\u030c\0\u030c\0\u030c\0\u030c"+
    "\0\u0f08\0\u030c";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[114];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length() - 1;
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpacktrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\2\3\1\0\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\2\26\1\27"+
    "\1\30\1\2\1\31\1\2\1\26\1\32\1\33\1\26"+
    "\1\34\1\35\1\26\1\36\5\26\1\37\1\26\1\40"+
    "\1\26\1\41\1\26\1\42\1\43\1\44\65\0\2\3"+
    "\1\0\1\3\104\0\1\45\36\0\6\46\1\47\55\46"+
    "\10\0\1\50\53\0\2\51\1\0\6\51\1\0\21\51"+
    "\1\52\30\51\25\0\1\53\63\0\1\54\52\0\1\55"+
    "\3\0\1\56\64\0\2\21\35\0\1\57\24\0\2\21"+
    "\66\0\1\60\63\0\1\61\63\0\1\62\57\0\2\26"+
    "\4\0\3\26\3\0\24\26\24\0\2\26\4\0\3\26"+
    "\3\0\16\26\1\63\5\26\24\0\2\26\4\0\3\26"+
    "\3\0\15\26\1\64\1\65\5\26\24\0\2\26\4\0"+
    "\3\26\3\0\1\26\1\66\10\26\1\67\2\26\1\70"+
    "\6\26\24\0\2\26\4\0\3\26\3\0\12\26\1\71"+
    "\11\26\24\0\2\26\4\0\3\26\3\0\1\26\1\72"+
    "\13\26\1\73\6\26\24\0\2\26\4\0\3\26\3\0"+
    "\6\26\1\74\5\26\1\75\7\26\24\0\2\26\4\0"+
    "\3\26\3\0\5\26\1\76\16\26\24\0\2\26\4\0"+
    "\3\26\3\0\16\26\1\77\5\26\24\0\2\26\4\0"+
    "\3\26\3\0\15\26\1\100\6\26\65\0\1\101\12\0"+
    "\1\102\63\0\1\103\21\0\1\104\15\0\1\104\1\0"+
    "\1\104\1\0\1\104\6\0\14\55\1\105\47\55\2\56"+
    "\3\0\57\56\21\0\2\106\4\0\1\106\6\0\6\106"+
    "\41\0\2\26\4\0\3\26\3\0\15\26\1\107\6\26"+
    "\24\0\2\26\4\0\3\26\3\0\15\26\1\110\6\26"+
    "\24\0\2\26\4\0\3\26\3\0\5\26\1\111\16\26"+
    "\24\0\2\26\4\0\3\26\3\0\12\26\1\112\11\26"+
    "\24\0\2\26\4\0\3\26\3\0\1\26\1\113\22\26"+
    "\24\0\2\26\4\0\3\26\3\0\14\26\1\114\7\26"+
    "\24\0\2\26\4\0\3\26\3\0\17\26\1\115\4\26"+
    "\24\0\2\26\4\0\3\26\3\0\12\26\1\116\11\26"+
    "\24\0\2\26\4\0\3\26\3\0\16\26\1\117\5\26"+
    "\24\0\2\26\4\0\3\26\3\0\20\26\1\120\3\26"+
    "\24\0\2\26\4\0\3\26\3\0\20\26\1\121\3\26"+
    "\24\0\2\26\4\0\3\26\3\0\21\26\1\122\2\26"+
    "\24\0\2\26\4\0\3\26\3\0\10\26\1\123\13\26"+
    "\14\0\1\124\52\0\14\55\1\105\3\55\1\125\43\55"+
    "\21\0\2\26\4\0\3\26\3\0\7\26\1\126\14\26"+
    "\24\0\2\26\4\0\3\26\3\0\12\26\1\127\11\26"+
    "\24\0\2\26\4\0\3\26\3\0\1\26\1\130\22\26"+
    "\24\0\2\26\4\0\3\26\3\0\12\26\1\131\11\26"+
    "\24\0\2\26\4\0\3\26\3\0\17\26\1\132\4\26"+
    "\24\0\2\26\4\0\3\26\3\0\20\26\1\133\3\26"+
    "\24\0\2\26\4\0\3\26\3\0\5\26\1\134\16\26"+
    "\24\0\2\26\4\0\3\26\3\0\17\26\1\135\4\26"+
    "\24\0\2\26\4\0\3\26\3\0\21\26\1\136\2\26"+
    "\24\0\2\26\4\0\3\26\3\0\5\26\1\137\16\26"+
    "\24\0\2\26\4\0\3\26\3\0\4\26\1\140\17\26"+
    "\24\0\2\26\4\0\3\26\3\0\16\26\1\141\5\26"+
    "\24\0\2\26\4\0\3\26\3\0\5\26\1\142\16\26"+
    "\24\0\2\26\4\0\3\26\3\0\11\26\1\143\12\26"+
    "\24\0\2\26\4\0\3\26\3\0\15\26\1\144\6\26"+
    "\24\0\2\26\4\0\3\26\3\0\17\26\1\145\4\26"+
    "\24\0\2\26\4\0\3\26\3\0\10\26\1\146\13\26"+
    "\24\0\2\26\4\0\3\26\3\0\5\26\1\147\16\26"+
    "\24\0\2\26\4\0\3\26\3\0\16\26\1\150\5\26"+
    "\24\0\2\26\4\0\3\26\3\0\1\26\1\151\22\26"+
    "\24\0\2\26\4\0\3\26\3\0\1\26\1\152\22\26"+
    "\24\0\2\26\4\0\3\26\3\0\21\26\1\153\2\26"+
    "\24\0\2\26\4\0\3\26\3\0\14\26\1\154\7\26"+
    "\24\0\2\26\4\0\3\26\3\0\14\26\1\155\7\26"+
    "\24\0\2\26\4\0\3\26\3\0\13\26\1\156\10\26"+
    "\24\0\2\26\4\0\3\26\3\0\14\26\1\157\7\26"+
    "\24\0\2\26\4\0\3\26\3\0\20\26\1\160\3\26"+
    "\24\0\2\26\4\0\3\26\3\0\21\26\1\161\2\26"+
    "\24\0\2\26\4\0\3\26\3\0\5\26\1\162\16\26"+
    "\3\0";

  private static int [] zzUnpacktrans() {
    int [] result = new int[3900];
    int offset = 0;
    offset = zzUnpacktrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpacktrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\3\1\1\11\2\1\3\11\1\1\1\11"+
    "\4\1\1\11\5\1\2\11\10\1\1\11\1\1\2\11"+
    "\1\0\2\11\2\0\2\11\1\0\1\1\1\0\3\11"+
    "\16\1\2\11\1\1\2\0\16\1\2\11\35\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[114];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen())];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;

  /* user code: */
  private Symbol symbol(int type) {
    return new Symbol(type, yyline + 1, yycolumn + 1);
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline + 1, yycolumn + 1, value);
  }

  public void printToken(Symbol token) {
    System.out.printf("(línea: %d, columna: %d, token: %s, valor: %s)\n",
        token.left, token.right, sym.terminalNames[token.sym], token.value);
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** Returns the maximum size of the scanner buffer, which limits the size of tokens. */
  private int zzMaxBufferLen() {
    return Integer.MAX_VALUE;
  }

  /**  Whether the scanner buffer can grow to accommodate a larger token. */
  private boolean zzCanGrow() {
    return true;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate && zzCanGrow()) {
      /* if not, and it can grow: blow it up */
      char newBuffer[] = new char[Math.min(zzBuffer.length * 2, zzMaxBufferLen())];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      if (requested == 0) {
        throw new java.io.EOFException("Scan buffer limit reached ["+zzBuffer.length+"]");
      }
      else {
        throw new java.io.IOException(
            "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
      }
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    int initBufferSize = Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen());
    if (zzBuffer.length > initBufferSize) {
      zzBuffer = new char[initBufferSize];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
  yyclose();    }
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  @Override  public java_cup.runtime.Symbol next_token() throws java.io.IOException
  {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
              {
                return symbol(sym.EOF);
              }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { throw new RuntimeException("Caracter ilegal: '" + yytext() + "' en la línea " + (yyline + 1) + ", columna " + (yycolumn + 1));
            }
          // fall through
          case 50: break;
          case 2:
            { /* ignore whitespace */
            }
          // fall through
          case 51: break;
          case 3:
            { return symbol(sym.NOT, yytext());
            }
          // fall through
          case 52: break;
          case 4:
            { return symbol(sym.MOD, yytext());
            }
          // fall through
          case 53: break;
          case 5:
            { return symbol(sym.LPAREN, yytext());
            }
          // fall through
          case 54: break;
          case 6:
            { return symbol(sym.RPAREN, yytext());
            }
          // fall through
          case 55: break;
          case 7:
            { return symbol(sym.TIMES, yytext());
            }
          // fall through
          case 56: break;
          case 8:
            { return symbol(sym.PLUS, yytext());
            }
          // fall through
          case 57: break;
          case 9:
            { return symbol(sym.COMMA, yytext());
            }
          // fall through
          case 58: break;
          case 10:
            { return symbol(sym.MINUS, yytext());
            }
          // fall through
          case 59: break;
          case 11:
            { return symbol(sym.DIVIDE, yytext());
            }
          // fall through
          case 60: break;
          case 12:
            { return symbol(sym.INT_LITERAL, Integer.parseInt(yytext()));
            }
          // fall through
          case 61: break;
          case 13:
            { return symbol(sym.SEMI, yytext());
            }
          // fall through
          case 62: break;
          case 14:
            { return symbol(sym.LT, yytext());
            }
          // fall through
          case 63: break;
          case 15:
            { return symbol(sym.ASSIGN, yytext());
            }
          // fall through
          case 64: break;
          case 16:
            { return symbol(sym.GT, yytext());
            }
          // fall through
          case 65: break;
          case 17:
            { return symbol(sym.ID, yytext());
            }
          // fall through
          case 66: break;
          case 18:
            { return symbol(sym.LBRACKET, yytext());
            }
          // fall through
          case 67: break;
          case 19:
            { return symbol(sym.RBRACKET, yytext());
            }
          // fall through
          case 68: break;
          case 20:
            { return symbol(sym.LCURLY, yytext());
            }
          // fall through
          case 69: break;
          case 21:
            { return symbol(sym.RCURLY, yytext());
            }
          // fall through
          case 70: break;
          case 22:
            { return symbol(sym.NEQ, yytext());
            }
          // fall through
          case 71: break;
          case 23:
            { return symbol(sym.STRING_LITERAL, yytext().substring(1, yytext().length() - 1));
            }
          // fall through
          case 72: break;
          case 24:
            { return symbol(sym.AND, yytext());
            }
          // fall through
          case 73: break;
          case 25:
            { return symbol(sym.PLUS_ASSIGN, yytext());
            }
          // fall through
          case 74: break;
          case 26:
            { return symbol(sym.MINUS_ASSIGN, yytext());
            }
          // fall through
          case 75: break;
          case 27:
            { /* Ignorar comentarios de una línea */
            }
          // fall through
          case 76: break;
          case 28:
            { return symbol(sym.LTE, yytext());
            }
          // fall through
          case 77: break;
          case 29:
            { return symbol(sym.EQ, yytext());
            }
          // fall through
          case 78: break;
          case 30:
            { return symbol(sym.GTE, yytext());
            }
          // fall through
          case 79: break;
          case 31:
            { return symbol(sym.IF, yytext());
            }
          // fall through
          case 80: break;
          case 32:
            { return symbol(sym.OR, yytext());
            }
          // fall through
          case 81: break;
          case 33:
            { return symbol(sym.CHAR_LITERAL, yytext().charAt(1));
            }
          // fall through
          case 82: break;
          case 34:
            { return symbol(sym.INT_LITERAL, Integer.parseInt(yytext().substring(2), 16));
            }
          // fall through
          case 83: break;
          case 35:
            { return symbol(sym.FOR, yytext());
            }
          // fall through
          case 84: break;
          case 36:
            { return symbol(sym.INT, yytext());
            }
          // fall through
          case 85: break;
          case 37:
            { return symbol(sym.CHAR_LITERAL, yytext().charAt(1) == 'n' ? '\n' : 
                                                   yytext().charAt(1) == 't' ? '\t' : 
                                                   yytext().charAt(1) == 'r' ? '\r' : 
                                                   yytext().charAt(1));
            }
          // fall through
          case 86: break;
          case 38:
            { /* Ignorar comentarios multilínea */
            }
          // fall through
          case 87: break;
          case 39:
            { return symbol(sym.ELSE, yytext());
            }
          // fall through
          case 88: break;
          case 40:
            { return symbol(sym.TRUE, yytext());
            }
          // fall through
          case 89: break;
          case 41:
            { return symbol(sym.VOID, yytext());
            }
          // fall through
          case 90: break;
          case 42:
            { return symbol(sym.BREAK, yytext());
            }
          // fall through
          case 91: break;
          case 43:
            { return symbol(sym.CLASS, yytext());
            }
          // fall through
          case 92: break;
          case 44:
            { return symbol(sym.FALSE, yytext());
            }
          // fall through
          case 93: break;
          case 45:
            { return symbol(sym.RETURN, yytext());
            }
          // fall through
          case 94: break;
          case 46:
            { return symbol(sym.PROGRAM_ID, yytext());
            }
          // fall through
          case 95: break;
          case 47:
            { return symbol(sym.BOOLEAN, yytext());
            }
          // fall through
          case 96: break;
          case 48:
            { return symbol(sym.CALLOUT, yytext());
            }
          // fall through
          case 97: break;
          case 49:
            { return symbol(sym.CONTINUE, yytext());
            }
          // fall through
          case 98: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
