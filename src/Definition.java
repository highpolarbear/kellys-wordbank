public class Definition {

    String definitionName;
    String definition;

    public Definition(String definitionName, String definition){
        this.definitionName = definitionName;
        this.definition = definition;
    }

    public void changeDefinitionName(String name){
        this.definitionName = name;
    }

    public void changeDefinitionValue(String value){
        this.definition = value;
    }

    public String getDefinitionName(){
        return definitionName;
    }

    public String getDefinition(){
        return definition;
    }
}
