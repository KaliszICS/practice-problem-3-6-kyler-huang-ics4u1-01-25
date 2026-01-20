import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
public class PracticeProblemTest {
@Test
@DisplayName("")
void SearchMazeMovesTest4() {
    Class<?> testClass = PracticeProblem.class;
    try {
        Class<?>[] cArg = {String[][].class};
        Method method = testClass.getDeclaredMethod("searchMazeMoves", cArg);
  // Enter code here
  String[][] maze = {
    {"S", "*", "F"},
  };
    assertEquals(-1, (int)method.invoke(null, new Object[]{maze}));
}


    catch (NoSuchMethodException e) {
        fail("Method does not exist");
}
    catch(Exception e) {
        fail("Something weird happened");
}
}
@Test
@DisplayName("")
void MathPathsTest4() {
    Class<?> testClass = PracticeProblem.class;
    try {
        Class<?>[] cArg = {String[][].class};
        Method method = testClass.getDeclaredMethod("noOfPaths", cArg);
  // Enter code here
  String[][] maze = {
    {"S", "*", "F"},
  };
    assertEquals(0, (int)method.invoke(null, new Object[]{maze}));
}


    catch (NoSuchMethodException e) {
        fail("Method does not exist");
}
    catch(Exception e) {
        fail("Something weird happened");
}
}
@Test
@DisplayName("")
void MathPathsTest3() {
    Class<?> testClass = PracticeProblem.class;
    try {
        Class<?>[] cArg = {String[][].class};
        Method method = testClass.getDeclaredMethod("noOfPaths", cArg);
  // Enter code here
    String[][] maze = {
    {"", "", "*", "F"},
    {"", "", "*", ""},
    {"", "", "*", ""},
    {"S", "", "", ""},
  };
    assertEquals(1, (int)method.invoke(null, new Object[]{maze}));
}


    catch (NoSuchMethodException e) {
        fail("Method does not exist");
}
    catch(Exception e) {
        fail("Something weird happened");
}
}
@Test
@DisplayName("")
void MazePathsTest2() {
    Class<?> testClass = PracticeProblem.class;
    try {
        Class<?>[] cArg = {String[][].class};
        Method method = testClass.getDeclaredMethod("noOfPaths", cArg);
  // Enter code here
  String[][] maze = {
    {"", "", "", "", ""},
    {"", "*", "F", "", ""},
    {"", "", "", "", ""},
    {"S", "", "", "", ""},
  };
    assertEquals(3, (int)method.invoke(null, new Object[]{maze}));
}


    catch (NoSuchMethodException e) {
        fail("Method does not exist");
}
    catch(Exception e) {
        fail("Something weird happened");
}
}
@Test
@DisplayName("")
void MazePathsTest1() {
    Class<?> testClass = PracticeProblem.class;
    try {
        Class<?>[] cArg = {String[][].class};
        Method method = testClass.getDeclaredMethod("noOfPaths", cArg);
  // Enter code here
  String[][] maze = {
    {"", "", "", "", ""},
    {"", "", "", "", ""},
    {"", "", "", "F", ""},
    {"S", "*", "*", "", ""},
  };
    assertEquals(1, (int)method.invoke(null, new Object[]{maze}));
}


    catch (NoSuchMethodException e) {
        fail("Method does not exist");
}
    catch(Exception e) {
        fail("Something weird happened");
}
}
@Test
@DisplayName("")
void searchMazeMovesTest1() {
    Class<?> testClass = PracticeProblem.class;
    try {
        Class<?>[] cArg = {String[][].class};
        Method method = testClass.getDeclaredMethod("searchMazeMoves", cArg);
  // Enter code here
  String[][] maze = {
    {"", "", "", ""},
    {"", "", "", ""},
    {"", "", "", "F"},
    {"S", "*", "*", "*"},
  };
    assertEquals(4, (int)method.invoke(null, new Object[]{maze}));
}


    catch (NoSuchMethodException e) {
        fail("Method does not exist");
}
    catch(Exception e) {
        fail("Something weird happened");
}
}
@Test
@DisplayName("")
void SearchMazeMovesTest2() {
    Class<?> testClass = PracticeProblem.class;
    try {
        Class<?>[] cArg = {String[][].class};
        Method method = testClass.getDeclaredMethod("searchMazeMoves", cArg);
  // Enter code here
  String[][] maze = {
    {"", "", "", "", ""},
    {"", "", "", "", ""},
    {"", "", "*", "F", ""},
    {"S", "*", "", "", ""},
  };
    assertEquals(-1, (int)method.invoke(null, new Object[]{maze}));
}


    catch (NoSuchMethodException e) {
        fail("Method does not exist");
}
    catch(Exception e) {
        fail("Something weird happened");
}
}
@Test
@DisplayName("")
void SearchMazeMovesTest3() {
    Class<?> testClass = PracticeProblem.class;
    try {
        Class<?>[] cArg = {String[][].class};
        Method method = testClass.getDeclaredMethod("searchMazeMoves", cArg);
  // Enter code here
  String[][] maze = {
    {"", "", "F", "", ""},
    {"", "*", "", "", ""},
    {"", "*", "", "", ""},
    {"S", "*", "", "", ""},
  };
    assertEquals(5, (int)method.invoke(null, new Object[]{maze}));
}


    catch (NoSuchMethodException e) {
        fail("Method does not exist");
}
    catch(Exception e) {
        fail("Something weird happened");
}
}
}