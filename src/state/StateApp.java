package state;

/**
 * Created by Артем on 25.05.2016.
 */
public class StateApp {
    public static void main(String[] args) {
        Station era=new RadioEra();
        Radio radio=new Radio();
        radio.setStation(era);

        for(int i=0;i<10;i++){
            radio.play();
            radio.nextStation();
        }

    }
}

//State
interface Station {
    void play();
}

//Context
class Radio {
    Station station;

    public void setStation(Station station) {
        this.station = station;
    }

    void nextStation() {
        if (station instanceof RadioRelax) {
            setStation(new RadioEra());
        } else if (station instanceof RadioEra) {
            setStation(new RadioShanson());
        } else if (station instanceof RadioShanson) {
            setStation(new RadioRelax());
        }
    }

    void play() {
        station.play();
    }
}

//ConcreteState
class RadioRelax implements Station {
    @Override
    public void play() {
        System.out.println("Radio relax play");
    }
}

class RadioEra implements Station {
    @Override
    public void play() {
        System.out.println("Radio Era play");
    }
}

class RadioShanson implements Station {
    @Override
    public void play() {
        System.out.println("Radio Shanson play");
    }
}