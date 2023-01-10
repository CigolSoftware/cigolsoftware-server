package com.cigolsoftware.cigol.utilities;

public class Constants {

	public static final class Aspect {
		public static final String ANNOTATION = "@annotation(org.springframework.web.bind.annotation.PostMapping)";
		public static final String ENTITY = "entity";
		public static final String POINTCUT = "pointcut()";

		private Aspect() {
		}
	}

	public static final class Column {
		public static final String ID_PRO = Param.ID + Column.PRO;
		public static final String NAME_PRO = Param.NAME + Column.PRO;
		private static final String PRO = "_pro";

		private Column() {
		}
	}

	public static final class Logger {
		public static final String CONTROLLED = "Controlled";
		public static final String ERROR = "Error";
		public static final String FORMAT = "[{}] {}: {}";
		public static final String REQUEST = "Request";
		public static final String RESPONSE = "Response";

		private Logger() {
		}
	}

	public static final class Mapping {
		public static final String EXISTS = "exists";

		private Mapping() {
		}
	}

	public static final class Param {
		public static final String ID = "id";
		public static final String NAME = "name";

		private Param() {
		}
	}

	public static final class Query {
		public static final String EXISTS = "SELECT COUNT(0) > 0 FROM projects WHERE id_pro <> :id AND name_pro = :name";

		private Query() {
		}
	}

	public static final String NAME = "name";
	public static final String PROJECTS = "projects";

	private Constants() {

	}
}