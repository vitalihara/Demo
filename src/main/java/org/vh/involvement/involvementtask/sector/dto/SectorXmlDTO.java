package org.vh.involvement.involvementtask.sector.dto;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
@JacksonXmlRootElement(localName = "sector")
public class SectorXmlDTO {
    @JacksonXmlProperty(isAttribute = true)
    private Long id;
    private String name;
    private Long parentId;
    // TEST
    @JacksonXmlProperty(isAttribute = true)
    private String staticAttribute = "attr";
    private String staticTag = "tag";
    @JacksonXmlText
    private String staticText = "text";
    private TestDTO test = new TestDTO();
    @JacksonXmlElementWrapper(useWrapping = true, localName = "items")
    @JacksonXmlProperty(localName = "item")
    private List<TestDTO> items = Collections.singletonList(new TestDTO());
}
