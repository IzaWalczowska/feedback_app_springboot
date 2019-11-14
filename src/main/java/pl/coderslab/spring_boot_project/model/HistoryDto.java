package pl.coderslab.spring_boot_project.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class HistoryDto implements Comparable<HistoryDto>{
    String author;
    String created;
    String imageSource;
    String content;
    List<String> requests;

    @Override
    public int compareTo(HistoryDto historyDto) {

        return historyDto.created.compareTo(this.created);

    }
}
