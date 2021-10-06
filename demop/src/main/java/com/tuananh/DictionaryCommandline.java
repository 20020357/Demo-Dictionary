package com.tuananh;

import com.tuananh.entities.*;

public class DictionaryCommandline {
	public void showAllWords() {
		System.out.println("No" + "\t| English" + "\t" + "\t| Vietnamese");

		for (int i = 0; i < VariableManagement.D.listWords.size(); i++) {
			System.out.println((i+ 1) + "\t| " + VariableManagement.D.listWords.get(i).getWordTarget()
            + "\t" + "\t| " + VariableManagement.D.listWords.get(i).getWordExplain());
		}
	}

	public void dictionaryBasic() {
		VariableManagement.DM.insertFromCommandline();
		showAllWords();
	}

  public void dictionaryAdvanced() {
    VariableManagement.DM.insertFromFile();
    showAllWords();
    VariableManagement.DM.dictionaryLookup();
    VariableManagement.DM.addWord();
  }

	public static void main(String[] args) {
		DictionaryCommandline test = new DictionaryCommandline();
		//test.dictionaryBasic();
    test.dictionaryAdvanced();
	}
}