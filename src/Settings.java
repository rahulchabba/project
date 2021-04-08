import java.util.Properties;

public enum Settings
{
   EQUIPMENT_HEIGHT("equipment.height", "0"),

   EQUIPMENT_WIDTH("equipment.width", "0"),

   EQUIPMENT_DEPTH("equipment.depth", "0");

   private String property;

   private String value;

   Settings(final String aProperty, final String aValue)
   {
      property = aProperty;
      value = aValue;
   }

   public String getProperty()
   {
      return property;
   }

   public String getValue()
   {
      return value;
   }

   private void setValue(final String aValue)
   {
      value = aValue;
   }

   public static void initialize(final Properties aPropertyTable)
   {
      for(final Settings setting : values())
      {
         final String key = setting.getProperty();
         final String defaultValue = setting.getValue();
         setting.setValue(aPropertyTable.getProperty(key, defaultValue));
      }
   }
}