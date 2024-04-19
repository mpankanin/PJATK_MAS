import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public abstract class ObjectPlusPlus extends ObjectPlus implements Serializable {

    private Map<String, Map<Object, ObjectPlusPlus>> links = new Hashtable<>();

    private static Set<ObjectPlusPlus> allParts = new HashSet<>();

    public ObjectPlusPlus() {
        super();
    }

    private void addLink(String roleName, String reverseRoleName, ObjectPlusPlus targetObject, Object qualifier, int counter){
        Map<Object, ObjectPlusPlus> objectLinks;

        if(counter < 1){
            return;
        }

        if(links.containsKey(roleName)){
            objectLinks = links.get(roleName);
        }else {
            objectLinks = new HashMap<>();
            links.put(roleName, objectLinks);
        }

        if(!objectLinks.containsKey(qualifier)){
            objectLinks.put(qualifier, targetObject);

            targetObject.addLink(reverseRoleName, roleName, this, this, counter - 1);
        }
    }

    public void addLink(String roleName, String reverseRoleName, ObjectPlusPlus targetObject, Object qualifier){
        addLink(roleName, reverseRoleName, targetObject, 2);
    }

    public void addLink(String roleName, String reverseRoleName, ObjectPlusPlus targetObject){
        addLink(roleName, reverseRoleName, targetObject);
    }


}
