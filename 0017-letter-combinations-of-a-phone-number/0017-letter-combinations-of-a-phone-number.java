class Solution {
    private static final Map<Character, List<Character>> digitMap = Map.of(
			'0', List.of(), 
			'1', List.of(), 
			'2', List.of('a', 'b', 'c'), 
			'3', List.of('d', 'e', 'f'), 
			'4', List.of('g', 'h', 'i'), 
			'5', List.of('j', 'k', 'l'), 
			'6', List.of('m', 'n', 'o'), 
			'7', List.of('p', 'q', 'r', 's'), 
			'8', List.of('t', 'u', 'v'), 
			'9', List.of('w', 'x', 'y', 'z')
	);

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.isEmpty())    return result;
        func(digits, result, new StringBuilder());
        return result;
    }

    public void func(String digits, List<String> result, StringBuilder sb){
        int n = sb.length();
        if(n==digits.length()){
            result.add(sb.toString());
            return;
        }

        for(char ch : digitMap.get(digits.charAt(n))){
            sb.append(ch);
            func(digits,result,sb);
            sb.setLength(n);
        }
    }
}