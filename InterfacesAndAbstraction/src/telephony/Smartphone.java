package telephony;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Smartphone implements Callable,Browsable {
    private List<String> numbers;
    private List<String> urls;
    private static final String regForNums="^[0-9]+$";
    private static final String regForURL= "^\\D+$";

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder build=new StringBuilder();
        Pattern pattern = Pattern.compile(regForURL);
        for(String cur:urls){
            Matcher matcher=pattern.matcher(cur);
            if(matcher.matches()){
                build.append(String.format("Browsing: %s!%n",cur));
            }
            else{
                build.append("Invalid URL!");
                build.append(System.lineSeparator());
            }

        }
        return build.toString();

    }

    @Override
    public String call() {
        StringBuilder build=new StringBuilder();
        Pattern pattern = Pattern.compile(regForNums);
        for(String cur:numbers){
            Matcher matcher=pattern.matcher(cur);
            if(matcher.matches()){
                build.append(String.format("Calling... %s%n",cur));
            }
            else{
                build.append("Invalid number!");
                build.append(System.lineSeparator());
            }

        }
        return build.toString();

    }

}
