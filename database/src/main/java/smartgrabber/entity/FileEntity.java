package smartgrabber.entity;

import smartgrabber.enums.FileFormats;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fileName;
    @Temporal(TemporalType.DATE)
    private Date fileDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeOfCreation;
    @Enumerated(value = EnumType.ORDINAL)
    private FileFormats fileFormats = FileFormats.MP3;
    @Transient
    private String info;
    @ElementCollection(targetClass = String.class,fetch = FetchType.LAZY)
    @CollectionTable(name = "file_strings")
    private List<String> strings;
    @ElementCollection
    @CollectionTable(name = "map_strings")
    //@MapKeyColumn(name = "strings")
    private Map<Integer, String> map;

    public Map<Integer, String> getMap() {
        return map;
    }

    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }

    public Date getFileDate() {
        return fileDate;
    }

    public void setFileDate(Date fileDate) {
        this.fileDate = fileDate;
    }

    public Date getTimeOfCreation() {
        return timeOfCreation;
    }

    public void setTimeOfCreation(Date timeOfCreation) {
        this.timeOfCreation = timeOfCreation;
    }

    public FileFormats getFileFormats() {
        return fileFormats;
    }

    public void setFileFormats(FileFormats fileFormats) {
        this.fileFormats = fileFormats;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
