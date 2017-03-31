package com.company.algos;// TODO: deaclare and define all needed enums, interfaces and classes

import java.util.Scanner;

class WingPainter {
    private WingType type;
    private CharMap map;

    public WingPainter(WingType type) {
        this.type = type;
    }

    CharMap getWingMap() {
        return map;
    }

    protected char[][] fillArrayClockwise(int num) {
        if (num == 1) {
            return new char[][]{{'*', '*'}, {'*', '*'}};
        }

        char[][] array = new char[2 * num][2 * num];
        int numOfAsterisks = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j < array[i].length / 2) {
                    if (j < numOfAsterisks) {
                        array[i][j] = '*';
                    } else {
                        array[i][j] = '.';
                    }
                } else {
                    if (j < numOfAsterisks - 1) {
                        array[i][j] = '.';
                    } else {
                        array[i][j] = '*';
                    }
                }

                if (i > 0 && j >= array[i].length - numOfAsterisks + 1 && i < array.length / 2) {
                    array[i][j] = '.';
                } else if (i >= array.length / 2 && j < array[i].length - numOfAsterisks && i < array.length - 1) {
                    array[i][j] = '.';
                }
            }
            numOfAsterisks++;
        }
        return array;
    }

    protected char[][] fillArrayCounterClockwise(int num) {
        if (num == 1) {
            return new char[][]{{'*', '*'}, {'*', '*'}};
        }

        char[][] array = new char[2 * num][2 * num];
        int numOfDots = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j < array[i].length / 2) {
                    if (j < numOfDots - 1) {
                        array[i][j] = '.';
                    } else {
                        array[i][j] = '*';
                    }
                } else {
                    if (j < numOfDots) {
                        array[i][j] = '*';
                    } else {
                        array[i][j] = '.';
                    }
                }

                if (i >= 0 && j >= array[i].length - numOfDots && i < array.length / 2) {
                    array[i][j] = '*';
                } else if (i >= array.length / 2 && j < array[i].length - numOfDots + 1 && i <= array.length - 1) {
                    array[i][j] = '*';
                }
            }
            numOfDots++;
        }
        return array;
    }

    protected char[][] fillArrayRecursive(char[][] array, int size, FanDirection direction) {
        int startIndex = array.length / 2 - size;
        int endIndex = array.length / 2 + size;
        final char asterisk = '*';
        final char dot = '.';

        if (direction == FanDirection.Clockwise) {
            if (size >= 1) {
                array[startIndex][endIndex - 1] = asterisk;
                array[startIndex][startIndex] = asterisk;
                array[endIndex - 1][startIndex] = asterisk;
                array[endIndex - 1][endIndex - 1] = asterisk;
                if (size > 1) {
                    for (int i = startIndex + 1; i < endIndex - 1; i++) {
                        if (i < array.length / 2) {
                            array[startIndex][i] = dot;
                            array[i][startIndex] = asterisk;
                        } else {
                            array[startIndex][i] = asterisk;
                            array[i][startIndex] = dot;
                        }
                    }

                    for (int i = array.length / 2; i < array.length; i++) {
                        array[startIndex + 1][i] = dot;
                        array[i][startIndex + 1] = asterisk;
                        array[endIndex - 2][i] = asterisk;
                        array[i][endIndex - 2] = dot;
                    }

                }
                array = fillArrayRecursive(array, size - 1, FanDirection.Clockwise);
            }
        } else if (direction == FanDirection.CounterClockwise) {
            if (size >= 1) {
                array[startIndex][endIndex - 1] = asterisk;
                array[startIndex][startIndex] = asterisk;
                array[endIndex - 1][startIndex] = asterisk;
                array[endIndex - 1][endIndex - 1] = asterisk;
                if (size > 1) {
                    for (int i = startIndex + 1; i < endIndex - 1; i++) {
                        if (i < array.length / 2) {
                            array[startIndex][i] = asterisk;
                            array[i][startIndex] = dot;
                        } else {
                            array[startIndex][i] = dot;
                            array[i][startIndex] = asterisk;
                        }
                    }

                    for (int i = array.length / 2; i < array.length; i++) {
                        array[startIndex + 1][i] = asterisk;
                        array[i][startIndex + 1] = dot;
                        array[endIndex - 2][i] = dot;
                        array[i][endIndex - 2] = asterisk;
                    }

                }
                array = fillArrayRecursive(array, size - 1, FanDirection.CounterClockwise);
            }
        }

        return array;
    }
}

interface WingedFanPrinter {
    void printFan(int num, FanDirection direction);
}

class WingPainterFactory {
    public static WingPainter getWingPainter(WingType type) {
        return new WingPainter(type);
    }
}

class CharMap {
    private char[][] contents;

    public CharMap(char[][] contents) {
        this.contents = contents;
    }

    public char[][] getContents() {
        return contents;
    }
}

class WingedFanPrinterQuadrupleSymmetry extends WingPainter implements WingedFanPrinter {
    private CharMap map;

    public WingedFanPrinterQuadrupleSymmetry(CharMap map) {
        super(WingType.AsteriskTriangle);
        this.map = map;
    }

    private void printMap(CharMap map) {
        for (char[] rowInMapContents : map.getContents()) {
            for (int j = 0; j < rowInMapContents.length; j++) {
                if (j == rowInMapContents.length - 1) {
                    System.out.print(rowInMapContents[j] + "\n");
                } else {
                    System.out.print(rowInMapContents[j]);
                }
            }
        }
    }

    private char[][] initializeArray(int size) {
        return new char[2 * size][2 * size];
    }

    @Override
    public void printFan(int size, FanDirection direction) {
        map = new CharMap(fillArrayRecursive(initializeArray(size), size, direction));
        printMap(map);
//      Poprzednia implementacja dla iteracyjnych metod
//        switch (direction){
//            case Clockwise:
//                map = new CharMap(fillArrayClockwise(size));
//                printMap(map);
//                break;
//            case CounterClockwise:
//                map = new CharMap(fillArrayCounterClockwise(size));
//                printMap(map);
//                break;
//        }
    }

    @Override
    public CharMap getWingMap() {
        return map;
    }
}

enum FanPrinterType {
    QuadrupleSymmetry, DoubleSymmetry
}

enum WingType {
    AsteriskTriangle
}

enum FanDirection {
    Clockwise, CounterClockwise
}


class WingedFanPrinterFactory {
    public static WingedFanPrinter getWingedFanPrinter(FanPrinterType type) {
        WingPainter painter = WingPainterFactory.getWingPainter(WingType.AsteriskTriangle);
        CharMap wingMap = painter.getWingMap();
        if (type == FanPrinterType.QuadrupleSymmetry) {
            return new WingedFanPrinterQuadrupleSymmetry(wingMap);
        }
        throw new IllegalArgumentException("Illegal FanPrinterType: " + type);
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        WingedFanPrinter fanPrinter = WingedFanPrinterFactory.getWingedFanPrinter(FanPrinterType.QuadrupleSymmetry);
//        Kod wykonania z początkowej wersji aplikacji
//        long t1 = System.currentTimeMillis();
//        fanPrinter.printFan(4, FanDirection.CounterClockwise);
//        long t2 = System.currentTimeMillis();
//        System.out.println("Time of execution: " + (t2 - t1));

//      Dopasowane do opisu zadania na spoj
        Scanner input = new Scanner(System.in);
        int size = 1;
        while (size != 0) {
            size=input.nextInt();
            if (size > 0) {
                fanPrinter.printFan(size, FanDirection.Clockwise);
            } else if (size < 0) {
                fanPrinter.printFan(Math.abs(size), FanDirection.CounterClockwise);
            }
        }
    }
}
