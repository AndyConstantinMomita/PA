import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        var residents = IntStream.rangeClosed(0, 3).mapToObj(i -> new Resident("Resident" + i)).toArray(Resident[]::new);
        var hospitals = IntStream.rangeClosed(0, 2).mapToObj(i -> new Hospital("Hospital" + i, i + 1)).toArray(Hospital[]::new);
        hospitals[2].setCapacity(hospitals[2].getCapacity() - 1);

        List<Resident> residentList = new ArrayList<>();
        residentList.addAll(Arrays.asList(residents));

        Set<Hospital> hospitalSet = new TreeSet<>();
        hospitalSet.addAll(Arrays.asList(hospitals));

        Collections.sort(residentList, Comparator.comparing(Resident::getName));

        Map<Resident, List<Hospital>> residentPreferencesMap = new HashMap<>();
        residentPreferencesMap.put(residents[0], Arrays.asList(hospitals[0], hospitals[1], hospitals[2]));
        residentPreferencesMap.put(residents[1], Arrays.asList(hospitals[0], hospitals[1], hospitals[2]));
        residentPreferencesMap.put(residents[2], Arrays.asList(hospitals[0], hospitals[1]));
        residentPreferencesMap.put(residents[3], Arrays.asList(hospitals[0], hospitals[2]));

        Map<Hospital, List<Resident>> hospitalPreferencesMap = new LinkedHashMap<>();
        hospitalPreferencesMap.put(hospitals[0], Arrays.asList(residents[3], residents[0], residents[1], residents[2]));
        hospitalPreferencesMap.put(hospitals[1], Arrays.asList(residents[0], residents[2], residents[1]));
        hospitalPreferencesMap.put(hospitals[1], Arrays.asList(residents[0], residents[1], residents[3]));

        System.out.println(residentPreferencesMap.toString());
        System.out.println(hospitalPreferencesMap.toString());

        List<Hospital> residentTarget = Arrays.asList(hospitals[0], hospitals[2]);
        List<Resident> residentResult = residentList.stream().filter(resident -> residentPreferencesMap.get(resident).containsAll(residentTarget)).collect(Collectors.toList());
        System.out.println("\n" + residentResult.toString() + "\n");

    }
}
