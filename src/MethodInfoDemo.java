import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Demonstrates how to get simple method information.
 * 
 * @author <a href=mailto:kraythe@arcor.de>Robert Simmons jr. (kraythe)</a>
 * @version $Revision: 1.3 $
 */
public class MethodInfoDemo {
  /**
   * __UNDOCUMENTED__
   * 
   * @param obj
   *          __UNDOCUMENTED__
   * 
   * @throws IllegalAccessException
   *           __UNDOCUMENTED__
   * @throws InvocationTargetException
   *           __UNDOCUMENTED__
   */
  public static void emptyStrings(final Object obj) throws IllegalAccessException,
      InvocationTargetException {
    final String PREFIX = ""; //$NON-NLS-1$
    Method[] methods = obj.getClass().getMethods();
    for (int idx = 0; idx < methods.length; idx++) {
      if (methods[idx].getName().startsWith(PREFIX)) {
        if (methods[idx].getParameterTypes()[0] == String.class) {
          methods[idx].invoke(obj, new Object[] { new String() });
        }
      }
    }
  }

  /**
   * Demo method.
   * 
   * @param args
   *          Command line arguments.
   */
  public static void main(final String[] args) {
    String s = "";
    MethodInfoDemo v = new MethodInfoDemo();
    printMethodInfo(v);

    try {
      emptyStrings(s);
    } catch (final Exception ex) {
      ex.printStackTrace();
    }
  }

  /**
   * __UNDOCUMENTED__
   * 
   * @param obj
   *          __UNDOCUMENTED__
   */
  public static void printMethodInfo(final Object obj) {
    Class type = obj.getClass();
    final Method[] methods = type.getMethods();
    for (int idx = 0; idx < methods.length; idx++) {
      System.out.println(methods[idx]);
    }
  }
}