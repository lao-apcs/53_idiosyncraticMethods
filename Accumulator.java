/**
  Represent accumulating data from the elements in a
  List_inArraySlots that are of a particular type.
 */

 /*
 Java protects a programmer against applying a method to elements in list when some elements of the list might omit support for a particular operation.
 ``
 This protection is implemented by the compiler. The following attempt to violate the restriction is expected to result in the error unable to cast.

 public static String catElementsStartingWith(
     List_inArraySlots list
   , String prefix
   ) {
   String result = "[";
   for (int i = 0; i < list.size(); i++) {
         String string = list.get(i);
         if (string.startsWith(prefix))
             result += string + ",";
   }
   return result + "]";
 }

 Accumulator.java:49: error: incompatible types: Object cannot be converted to String

 */

 /*
 programmer should expect to be able to work around the stumbling block because the compiler knows the type of an element.

Java's instanceof operator identifies the type of an element to the compiler

Use of the operator alone is insufficient because the compiler continues to stumble over the previous stumbling block of protection against mis-applying a method.

public static String catElementsStartingWith(
    List_inArraySlots list
  , String prefix
  ) {
  String result = "[";
  for (int i = 0; i < list.size(); i++) {
      if (list.get(i) instanceof String) {
        String string = list.get(i);
        if (string.startsWith(prefix))
            result += string + ",";
    }
  }

  return result + "]";
}

predicted error message:
Accumulator.java:50: error: incompatible types: Object cannot be converted to String
 */

public class Accumulator {


    /**
      @return the concatenation of all the Strings
      in the \list that begin with \prefix,
      each followed by a space.
     */
    public static String catElementsStartingWith(
        List_inArraySlots list
      , String prefix
      ) {
      String result = "[";
      for (int i = 0; i < list.size(); i++) {
        if (list.get(i) instanceof String) {
            String string = (String)list.get(i);
            if (string.startsWith(prefix))
                result += string + ",";
        }
      }
      return result + "]";
    }


    /**
      @return a list of each of the Double elements
      from the \list whose value is "finite".
     */
    public static List_inArraySlots finites(
        List_inArraySlots list
      ) {
          List_inArraySlots result = new List_inArraySlots();
          for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Double) {
                if (!((Double)list.get(i)).isInfinite())
                    result.add(list.get(i));
            }
          }
          return result;
    }
}
