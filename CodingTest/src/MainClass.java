import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {

		Test test = new Test();
		try {
			test.machineCount();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Invalid input.");
		}
	}

}

class Test {

	public void machineCount() throws IOException {

		String input = "[[1,7],[1,9],[2,11],[2,3],[2,7],[7,8],[7,8]]";

		System.out.println("Please enter set of processes in below format: ");
		System.out.println(input + "\nInput:");
		// Enter data using BufferReader
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// Reading data using readLine

		input = reader.readLine();

		if (input.startsWith("[[") && input.endsWith("]]") && input.length() > 4) {

			String truncatedInp = input.substring(2, input.length() - 2); // 0,3],[15,18],[17,20],[2,10

			List<String> processStrList = Arrays.asList(truncatedInp.split("],\\[")); // [0,3, 15,18, 17,20, 2,10]

			List<Process> processList = createProcessList(processStrList); // [startTime: 0 endTime: 3, startTime: 15
																			// endTime: 18, startTime: 17 endTime: 20,
																			// startTime: 2 endTime: 10]

			Collections.sort(processList);

			List<Machine> machines = new ArrayList<Machine>();
			machines.add(new Machine());

			assignProcessToMachine(machines, processList);

			System.out.println("Final machinesAndProcess: " + machines);

			System.out.println("Output:\nTotal Machines Required: " + machines.size());
		} else {
			System.out.println("Invalid input.");
		}
	}

	private List<Process> createProcessList(List<String> processStrList) {
		List<Process> createdProcessList = new ArrayList<>();
		processStrList.forEach(eachStr -> {
			Process prc = new Process();
			String[] timesPerProcess = eachStr.split(",");
			if (timesPerProcess.length == 2) {
				prc.startTime = Integer.parseInt(timesPerProcess[0].trim());
				prc.endTime = Integer.parseInt(timesPerProcess[1].trim());
			}
			createdProcessList.add(prc);
		});
		return createdProcessList;
	}

	private void assignProcessToMachine(List<Machine> machines, List<Process> processList) {
		processList.forEach(prc -> {
			boolean isMachinesAccommodable = false;
			for (Machine machine : machines) {
				isMachinesAccommodable = canMachineAccomodateCurrentPrc(machine.processList, prc);
				if (isMachinesAccommodable) {
					machine.processList.add(prc);
					Collections.sort(machine.processList);
					break;
				}
			}
			if (!isMachinesAccommodable) {
				Machine newMachine = new Machine();
				newMachine.processList.add(prc);
				machines.add(newMachine);
			}
			Collections.sort(machines);
		});
	}

	private boolean canMachineAccomodateCurrentPrc(List<Process> machine, Process prc) {
		if (machine.size() == 0 || (machine.size() > 0 && machine.get(machine.size() - 1).endTime < prc.startTime)) {
			return true;
		}
		return false;

	}

}

class Process implements Comparable<Process> {

	int startTime;

	int endTime;

	@Override
	public String toString() {
		return "startTime: " + this.startTime + " endTime: " + this.endTime;
	}

	@Override
	public int compareTo(Process arg) {
		return Integer.compare(this.startTime, arg.startTime);
	}

}

class Machine implements Comparable<Machine> {

	List<Process> processList = new ArrayList<Process>();

	@Override
	public String toString() {
		return "processListofMachine: " + this.processList;
	}

	@Override
	public int compareTo(Machine arg) {
		return Integer.compare(this.processList.get(this.processList.size() - 1).endTime,
				arg.processList.get(arg.processList.size() - 1).endTime);
	}
	// A 0,3 5,6 10,15
	// B 0,2 16,18
}
