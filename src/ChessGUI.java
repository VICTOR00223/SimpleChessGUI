import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChessGUI
{
    private JFrame frame;
    private JButton[][] squares = new JButton[8][8];
    private char[][] board = new char[8][8];
    private int selectedRow = -1, selectedCol = -1;
    private boolean whiteToMove = true;

        // Unicode symbols for pieces
    private final String[][] pieceSymbols = {
                {"♚","♛","♜","♝","♞","♟"}, // black
                {"♔","♕","♖","♗","♘","♙"}  // white
        };

    public ChessGUI()
    {
        initBoard();
        frame = new JFrame("Simple Chess");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout layout = new GridLayout(8,8);
        frame.setLayout(layout);
        for (int r = 0; r < 8; r++)
        {
            for (int c = 0; c < 8; c++)
            {
                JButton btn = new JButton();
                btn.setFont(new Font("SansSerif", Font.PLAIN, 42));
                btn.setFocusPainted(false);
                final int row = r, col = c;
                btn.addActionListener(e -> handleClick(row, col));
                squares[r][c] = btn;
                frame.add(btn);
            }
        }
        updateBoard();
        frame.setSize(600,600);
        frame.setVisible(true);
    }

        private void initBoard()
        {
            char[][] start = {
                    {'r','n','b','q','k','b','n','r'},
                    {'p','p','p','p','p','p','p','p'},
                    {'.','.','.','.','.','.','.','.'},
                    {'.','.','.','.','.','.','.','.'},
                    {'.','.','.','.','.','.','.','.'},
                    {'.','.','.','.','.','.','.','.'},
                    {'P','P','P','P','P','P','P','P'},
                    {'R','N','B','Q','K','B','N','R'}
            };
            for (int r = 0; r < 8; r++) {
                board[r] = start[r];
            }
        }

        private void updateBoard() {
            for (int r = 0; r < 8; r++) {
                for (int c = 0; c < 8; c++) {
                    char piece = board[r][c];
                    squares[r][c].setText(pieceToSymbol(piece));
                    squares[r][c].setBackground((r+c)%2==0 ? Color.WHITE : Color.GRAY);
                }
            }
        }

        private String pieceToSymbol(char p) {
            switch(p) {
                case 'K': return pieceSymbols[1][0];
                case 'Q': return pieceSymbols[1][1];
                case 'R': return pieceSymbols[1][2];
                case 'B': return pieceSymbols[1][3];
                case 'N': return pieceSymbols[1][4];
                case 'P': return pieceSymbols[1][5];
                case 'k': return pieceSymbols[0][0];
                case 'q': return pieceSymbols[0][1];
                case 'r': return pieceSymbols[0][2];
                case 'b': return pieceSymbols[0][3];
                case 'n': return pieceSymbols[0][4];
                case 'p': return pieceSymbols[0][5];
                default: return "";
            }
        }

        private void handleClick(int row, int col) {
            if (selectedRow == -1) {
                // Select a piece
                if (board[row][col] != '.' &&
                        Character.isUpperCase(board[row][col]) == whiteToMove) {
                    selectedRow = row;
                    selectedCol = col;
                    squares[row][col].setBackground(Color.YELLOW);
                }
            } else {
                // Try to move
                char piece = board[selectedRow][selectedCol];
                if (isLegalMove(selectedRow, selectedCol, row, col)) {
                    board[row][col] = piece;
                    board[selectedRow][selectedCol] = '.';
                    whiteToMove = !whiteToMove;
                }
                selectedRow = selectedCol = -1;
                updateBoard();
            }
        }

        // Very simplified rules: only pawns move forward 1, knights move, and others move freely without check/checkmate
        private boolean isLegalMove(int fr, int fc, int tr, int tc) {
            char p = board[fr][fc];
            char dest = board[tr][tc];
            if (dest != '.' && Character.isUpperCase(dest) == Character.isUpperCase(p)) return false;

            int dr = tr - fr;
            int dc = tc - fc;
            switch (Character.toLowerCase(p)) {
                case 'p': // pawns simplified: move 1 forward or capture diag
                    int dir = Character.isUpperCase(p) ? -1 : 1;
                    if (dc == 0 && dr == dir && dest == '.') return true;
                    if (Math.abs(dc) == 1 && dr == dir && dest != '.') return true;
                    return false;
                case 'n': return (Math.abs(dr)==2 && Math.abs(dc)==1) || (Math.abs(dr)==1 && Math.abs(dc)==2);
                default:  return true; // for demo, all others can move anywhere
            }
        }
    }
