package task37.task3702;

public interface AbstractFactory {
    public <T extends Human> Human getPerson(int age);
}
