class ProjectTest{
  public static void main(String[] args){
    Project newProj1 = new Project("Investment ABC","Investment in ABC company which sells widgets");
    Project newProj2 = new Project("Investment XYZ"); 
    Project newProj3 = new Project();
    Project newProj4 = new Project();
    Project newProj5 = new Project();
    Project newProj6 = new Project();

    Portfolio newPort1 = new Portfolio();

    // System.out.println(newProj1.elevatorPitch());
    // System.out.println(newProj2.elevatorPitch());

    String nameProj2 = newProj2.getName();
    // System.out.println("The name of Project 2 is: " + nameProj2);
    
    String descProj1 = newProj1.getDesc();
    // System.out.println("The description of Project 1 is: " + descProj1);

    newProj3.setName("Travel Website");
    newProj3.setDesc("A travel website dedicated to retirees.");
    // System.out.println(newProj3.elevatorPitch());

    newProj4.setName("Internet Start-up");
    // System.out.println(newProj4.elevatorPitch());

    System.out.println(newProj5.elevatorPitch());

    //OPTIONAL CHALLENGES - not completed

    newProj6.setName("Clothing Website");
    newProj6.setInitCost(5000.);
    System.out.println(newProj6.elevatorPitch());

    // System.out.println(newProj6.getInitCost());
    // newPort1.setPortfolio()
  }
}