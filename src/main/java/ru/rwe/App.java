package ru.rwe;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( App.class.getName() +" by "
                + Property.TEST_MODE.entrySet().stream().findFirst().get().getKey()+" = "
                + Property.TEST_MODE.entrySet().stream().findFirst().get().getValue()
        );

        double usd = 1;
        double rub = 78.97;

        Neuro neuro = new Neuro();

        long i = 0;
        do{
            i++;

            neuro.trainNeuron(usd, rub);

            if( printToConsole(i) ) {
                System.out.println("шаг\t" + i + "\t\t\tошибка\t" + neuro.getLastError()+"\t\t\tзначение веса\t\t\t" + neuro.getWeight() );
            }
        }while (neuro.getLastError() > neuro.smoothing || neuro.getLastError() < -neuro.smoothing);

        System.out.printf("rub in 100 usd = %.2f %n" , neuro.processInputData(100) );
        System.out.printf("rub in 250 usd = %.2f %n" ,  neuro.processInputData(250) );
        System.out.printf("usd in 10 rub = %.2f %n" ,  neuro.restoreInputData(10) );
    }

    private static boolean printToConsole(long counter){
        //Показывать только каждый 1000000-й шаг если тестовый режим
        return Property.TEST_MODE.containsValue(false)  || Property.TEST_MODE.containsValue(true) && (counter % 1000000 == 0);
    }


}
