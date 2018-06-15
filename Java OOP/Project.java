public class Project{
  private String name;
  private String description;
  private Double initialCost;

  public void setName(String name){
    this.name = name;
  }

  public void setDesc(String description){
    this.description = description;
  }

  public void setInitCost(Double initialCost){
    this.initialCost = initialCost;
  }

  public String getName(){
    return name; 
  }

  public String getDesc(){
    return description;
  }

 public Double getInitCost(){
   return initialCost;
 }

  public Project(){

  }

  public Project(String nameParam){
    this.name = nameParam;
  }

  public Project(String nameParam, String descParam){
    this.name = nameParam;
    this.description = descParam;
  }

  public Project(String nameParam, String descParam, Double initialCostParam){
    this.name = nameParam;
    this.description = descParam;
    this.initialCost = initialCostParam;
  }

  public String elevatorPitch(){ 
    return name + "(" + initialCost + ")" + ": " + description;
  }
}