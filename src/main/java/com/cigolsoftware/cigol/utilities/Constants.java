package com.cigolsoftware.cigol.utilities;

public class Constants {

	public static final class Aspect {
		public static final String ANNOTATION = "@annotation(org.springframework.web.bind.annotation.DeleteMapping) || @annotation(org.springframework.web.bind.annotation.PostMapping) || @within(com.cigolsoftware.cigol.configurations.ControllerMapping)";
		public static final String ENTITY = "entity";
		public static final String POINTCUT = "pointcut()";

		private Aspect() {
		}
	}

	public static final class Column {
		public static final String EASY_SKI = "easy" + Column.SKI;
		public static final String HARD_SKI = "hard" + Column.SKI;
		public static final String ID_PRO = Param.ID + Column.PRO;
		public static final String ID_SKI = Param.ID + Column.SKI;
		public static final String MODIFICATION_PRO = Constants.Filter.MODIFICATION + Column.PRO;
		public static final String MODIFICATION_SKI = Constants.Filter.MODIFICATION + Column.SKI;
		public static final String NAME_PRO = Param.NAME + Column.PRO;
		public static final String NAME_SKI = Param.NAME + Column.SKI;
		public static final String NORMAL_SKI = "normal" + Column.SKI;

		private static final String PRO = "_pro";
		private static final String SKI = "_ski";

		private Column() {
		}
	}

	public static final class Filter {
		public static final String MODIFICATION = "modification";
		public static final Integer SIZE = 20;

		private Filter() {
		}
	}

	public static final class Logger {
		public static final String CONTROLLED = "Controlled";
		public static final String ERROR = "Error";
		public static final String FORMAT = "{}: {}";
		public static final String REQUEST = "Request";
		public static final String RESPONSE = "Response";

		private Logger() {
		}
	}

	public static final class Mapping {
		public static final String DELETE = "delete/{id}";
		public static final String EXISTS = "exists";
		public static final String FILTER = "filter";
		public static final String PROJECTS = "projects";
		public static final String SAVE = "save";
		public static final String SKILLS = "skills";

		private Mapping() {
		}
	}

	public static final class Param {
		public static final String ID = "id";
		public static final String NAME = "name";
		public static final String VALUE = "value";

		private Param() {
		}
	}

	public static final class Query {
		public static final String EXISTS_PROJECT = "SELECT COUNT(0) > 0 FROM projects WHERE id_pro <> :id AND name_pro = :name";
		public static final String EXISTS_SKILL = "SELECT COUNT(0) > 0 FROM skills WHERE id_ski <> :id AND name_ski = :name";

		private Query() {
		}
	}

	public static final class Repositories {
		public static final String PACKAGES = "com.cigolsoftware.cigol.repositories";

		private Repositories() {
		}
	}

	private Constants() {

	}
}
