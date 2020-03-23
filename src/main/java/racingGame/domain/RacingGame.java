package racingGame.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
	private List<Car> cars;

	public RacingGame(Car... cars) {
		this.cars = Arrays.asList(cars);
	}

	public void move() {
		cars.forEach(Car::move);
	}

	public List<Car> getCars(){
		return cars;
	}

	public List<String> getWinners() {
		int winDistance = getWinnerDistance();
		return cars.stream()
				.filter(car -> car.isSameDistance(winDistance))
				.map(Car::getRacer)
				.collect(Collectors.toList());
	}

	private int getWinnerDistance() {
		//noinspection OptionalGetWithoutIsPresent
		return cars.stream()
				.map(Car::getDistance)
				.max(Integer::compareTo)
				.get();
	}

}
