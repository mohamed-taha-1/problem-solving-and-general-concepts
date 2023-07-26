package jdkAPI_;

import java.util.Optional;

public class ProblemStatement {

	private static class UsbDrive {

		private WriteProtectSwitch writeProtectSwitch;

		public Optional<WriteProtectSwitch> getWriteProtectSwitch() {
			return Optional.ofNullable(writeProtectSwitch);
		}

	}

	public static void main(String[] args) {
		var computer = new Computer();

		computer.getUsbDrive().ifPresentOrElse(
				i -> i.getWriteProtectSwitch()
						.ifPresent((s) -> System.out.println("sysout i founded" + s.isSwitchedOn())),
				() -> System.out.println("Not found"));

		String str = null;

		Optional<String> taha = Optional.ofNullable(str);
		taha.ifPresentOrElse(t -> System.out.println(t),
				() -> System.out.println("ya taha you missed some thing.. go back for number 4 method"));

		Optional<String> str2 = Optional.ofNullable(str);
		System.out.println("the return val is: " + str2.orElse(ProblemStatement.getDefaultString()));

		Optional<String> str3 = Optional.ofNullable(str);
		System.out.println("the return val is: " + str2.orElseGet(ProblemStatement::getDefaultString));

		// this for lazy initialisation

		try {
			str3.orElseThrow(); // by default return nouchElementException
			str3.orElseThrow(() -> new RuntimeException()); // now you updated the default

		} catch (Exception e) {

		}

		/*
		 * now how to use filter
		 * 
		 * <T> if True: return the all filterStr else return the default
		 * 
		 */
		String filterStr = "welcom ya taha!";
		Optional<String> str4 = Optional.ofNullable(filterStr);
		System.out.println(str4.filter(s -> s.contains("mohaemd")).orElseGet(ProblemStatement::getDefaultString));

		/*
		 * now how to use filter for check if the user returned back from the database
		 * 
		 * <T> if True: return the all filterStr else return the default
		 * 
		 */

		mapMetho();
		flatMap();

	}

	private static void mapMetho() {

		// Loop for a single value from the user

		Optional<User> user1 = Optional.of(new User("ahmed", 1999));

		Integer value = user1.map(u -> u.getYearOfBirth()).filter(year -> year >= 1880).filter(ye -> ye <= 2001)
				.orElse(null);

		System.out.println(value);
		// --- now loop for all user data to be verified

		User ss = user1.map(u -> u).filter(u -> u.getYearOfBirth() >= 1880)
				.filter(ye -> ye.getName().get().equals("ahmed")).orElse(new User("moahmed", 2010));

		System.out.println(ss.getYearOfBirth());

	}

	private static void flatMap() {

		/*
		 * what is the difference between flat map <T> list<item>: then should use map
		 * 
		 * <T> list<list<item>>: then should use flatMap
		 * 
		 **/

		Optional<User> user1 = Optional.of(new User("ahmed", 1999));

		Optional<Optional<String>> str = user1.map(User::getName);
		Optional<String> nameOptional = str.orElseThrow(IllegalArgumentException::new);
		String name = nameOptional.orElse("");

		System.out.println(name);

		name = user1.flatMap(User::getName).orElse("");
		System.out.println(name);

		/*
		 * now my updated flatMap to kill nested Optional; because the GetName() method
		 * is optional also
		 */
		Optional<User> user2 = Optional.of(new User(null, 1999));
		Optional<String> str2 = user2.flatMap(User::getName);
		System.out.println(str2.orElse("sad yasta; yasta set the name value"));

	}

	private static String getDefaultString() {
		return "default string";
	}

	private static class User {

		private String name;
		private int yearOfBirth;

		public User(String name, int yearOfBirth) {
			this.name = name;
			this.yearOfBirth = yearOfBirth;
		}

		public int getYearOfBirth() {
			return this.yearOfBirth;
		}

		public Optional<String> getName() {
			return Optional.ofNullable(this.name);
		}
	}

	private static class Computer {

		private UsbDrive usbDrive;

		public Optional<UsbDrive> getUsbDrive() {
			return Optional.ofNullable(this.usbDrive);
		}
	}

	private static class WriteProtectSwitch {

		private boolean switchedOn = true;

		public boolean isSwitchedOn() {
			return this.switchedOn;
		}
	}
}
