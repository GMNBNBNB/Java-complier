class Term {
	Factor factor;
	Term term;
	int option;
	
	void parse() {
		factor  = new Factor();
		factor.parse();
		if (Parser.scanner.currentToken() == Core.MULTIPLY) {
			option = 1;
		} else if (Parser.scanner.currentToken() == Core.DIVIDE) {
			option = 2;
		}
		if (option != 0) {
			Parser.scanner.nextToken();
			term = new Term();
			term.parse();
		}						
	}
	
	void print() {
		factor.print();
		if (option == 1) {
			System.out.print("*");
			term.print();
		} else if (option == 2) {
			System.out.print("/");
			term.print();
		}
	}

	int execute(){
		int value = factor.execute();
		if (option == 1) {
			value = value * term.execute();
		} else if (option == 2) {
			int temp = term.execute();
			if(temp == 0){
				System.out.print("Error is division by 0");
				System.exit(0);
			}
			value = value / term.execute();
		}
		return value;
	}
}