package model;

/*  В задании было указано, что нам нужен пустой конструктор без параметров и присвоение значений котику осуществляется через метод setKotik.
 *   Но, покскольку конструктор без параметров есть, я добавил дефолтное значение для веса(взят средний по всем породам) и для имени, на случай создания пустого кота.
 *   Милость котика может равняться нулю и кот может быть немым. Но котик в любом случае что-то весит, а имя null для кота странное (Хотя, я сейчас подумал, что прикольно так назвать кота..).
 *   Так же, вес кота должен нахожиться в определённых пределах, поэтому, я добавил дополнительную проверку в конструктор и сеттер.
 *   Я догадываюсь, что в реальных приложениях довольно строго задаётся область допустимых значений и их проверка,
 *   да и названия методов из 9 слов - это дурной тон и сложно читается, но для первого домашнего задания я позволил себе эти вольности.
 */


public class Kotik {

    private static int count;

    private int prettiness;
    private int weight = 5;
    private String name = "Nameless Kotik";
    private String meow;
    private String food;
    private int fullness = 6;
    private int weightCheck;

    public Kotik() {
        count++;
    }

    public Kotik(int prettiness, String name, int weight, String meow) {
        this.prettiness = prettiness;
        this.name = name;
        this.meow = meow;
        this.weight = weight;
        if (weight <= 0) {
            weightCheck = -1;
        }
        if (weight > 0 && weight < 20) {
            weightCheck = 0;
        }
        if (weight > 20) {
            weightCheck = 1;
        }
        count++;
    }

    public void setKotik(int prettiness, String name, int weight, String meow) {
        this.prettiness = prettiness;
        this.name = name;
        this.meow = meow;
        this.weight = weight;
        if (weight <= 0) {
            weightCheck = -1;
        }
        if (weight > 0 && weight <= 20) {
            weightCheck = 0;
        }
        if (weight > 20) {
            weightCheck = 1;
        }
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public static int getCount() {
        return count;
    }

    public String getMeow() {
        return meow;
    }

    void eat() {
        eat(chooseFullness(), chooseFood());
    }

    void eat(int fullness) {
        this.fullness += fullness;
        System.out.println(name + "'s fullness is increasing by " + fullness);
    }

    void eat(int fullness, String food) {
        this.fullness += fullness;
        this.food = food;
        System.out.println(name + " is eating " + food);
    }

    private String chooseFood() {
        String[] food = {"fish.", "meat.", "Sheba.", "cucumber.", "my ciabatta which I bought for MY OWN DINNER!!"};
        int i = (int) (Math.random() * food.length);
        return food[i];
    }

    private int chooseFullness() {
        return (int) (Math.random() * 5 + 2);
    }

    private void hungry() {
        System.out.print(name + " is hungry. Again. ");
        eat();
    }


    private boolean playWithFood() {
        return fullness > 0;
    }

    private boolean stareOutOfAWindow() {
        return fullness > 0;
    }

    private boolean ruinFurniture() {
        return fullness > 0;
    }

    private boolean violentlyMeowing() {
        return fullness > 0;
    }

    private boolean sleepOnSomeonesKneesSoThePersonCantWalk() {
        return fullness > 0;
    }

    public void liveAnotherDay() {

        if (weightCheck == 0) {
            for (int i = 0; i < 24; i++) {
                int random = (int) (Math.random() * 5 + 1);
                switch (random) {
                    case 1:
                        if (playWithFood()) {
                            System.out.println(name + " is playing with " + chooseFood() + " Which one he used to eat!");
                            fullness--;
                        } else {
                            hungry();
                        }
                        break;
                    case 2:
                        if (stareOutOfAWindow()) {
                            System.out.println(name + " is staring out of a window for hours...");
                            fullness--;
                        } else {
                            hungry();
                        }
                        break;
                    case 3:
                        if (ruinFurniture()) {
                            System.out.println(name + " is ruining my new leather couch!");
                            fullness -= 3;
                        } else {
                            hungry();
                        }
                        break;
                    case 4:
                        if (violentlyMeowing()) {
                            System.out.println(name + " is meowing violently for hours!");
                            fullness -= 2;
                        } else {
                            hungry();
                        }
                        break;
                    case 5: {
                        if (sleepOnSomeonesKneesSoThePersonCantWalk()) {
                            System.out.println(name + " is sleeping on my knees and i can't feel my legs. Again.");
                            fullness--;
                        } else {
                            hungry();
                        }
                        break;
                    }
                }
            }
        }
        if (weightCheck == 1) {
            for (int i = 0; i < 24; i++) {
                System.out.println(name + " is very fat. He cant move.");
            }
        }
        if (weightCheck == -1) {
            for (int i = 0; i < 24; i++) {
                System.out.println("You created Kotik with negative weight. " +
                        "He appeared in parallel universe where mass can be negative. " +
                        "We don't know what he is doing now.");
            }
        }
    }
}

