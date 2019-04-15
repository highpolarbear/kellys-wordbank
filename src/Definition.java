public class Definition {

    String definitionName;
    String definition;
    String definitionShort;
    int shortLength = 35;

    public Definition(String definitionName, String definition){
        this.definitionName = definitionName;
        this.definition = definition;
        this.definitionShort = makeShortDefinition(this.definition);
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

    public String makeShortDefinition(String definition){
        String definitionShoterned = definition;
        if (definition.length() > shortLength){
            definitionShoterned = definitionShoterned.substring(0,shortLength).concat("...");
        }

        return definitionShoterned;
    }

    public String makeFormattedDefinition(String definition){
        String tempDefinition = definition.replaceAll("/NL/", "\n");
        String formattedDefinition = "";
        if (tempDefinition.length() > 60){

            for (int i = 59; i < tempDefinition.length() + tempDefinition.length()%60;  i += 60) {

                if (i> tempDefinition.length()){
                    formattedDefinition += tempDefinition.substring(i - 60 + 1).concat("\n");
                }
                else {
                    formattedDefinition += tempDefinition.substring(i - 60 + 1, i).concat("\n");
                }
            }
        }
        else{
            formattedDefinition = tempDefinition;
        }
        return formattedDefinition;
    }

    public String getFormattedDefinition(){
        String formattedDefinition = makeFormattedDefinition(definition);
        return formattedDefinition;
    }

    public String getDefinitionShort(){
        return definitionShort;
    }
}
