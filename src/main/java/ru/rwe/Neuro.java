package ru.rwe;

public class Neuro
{
    private double weight = 0.5; //Начальный вес нейрона
    private double lastError = 0.0;
    public final double smoothing = 0.00001; //Сглаживание, чтобы шаг коррекции не был очень большим

    public double getWeight(){ return weight; }

    public double getLastError() {
        return lastError;
    }

    public double processInputData(double input){
        return input * weight;
    }

    public double restoreInputData(double input){
        return input / weight;
    }

    public void trainNeuron(double input, double expectedResult){
        double currentResult = input * weight;
        lastError = expectedResult - currentResult;
        double correction = (lastError / currentResult) * smoothing;
        weight += correction;

    }

}
