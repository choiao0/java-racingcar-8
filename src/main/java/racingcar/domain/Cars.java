package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateCarNamesUnique(cars);
        this.cars = new ArrayList<>(cars);
    }

    private void validateCarNamesUnique(List<Car> cars) {
        Set<String> nameSet = new HashSet<>();
        for (Car car : cars) {
            checkUniqueName(nameSet, car.getName());
        }
    }

    private void checkUniqueName(Set<String> nameSet, String name) {
        if (!nameSet.add(name)) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    public Cars findWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        List<Car> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();

        return new Cars(winners);
    }

    public List<Car> getCars() {
        return cars;
    }
}
