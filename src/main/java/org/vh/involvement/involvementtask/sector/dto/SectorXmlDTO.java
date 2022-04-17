package org.vh.involvement.involvementtask.sector.dto;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "sector")
public class SectorXmlDTO {
    @JacksonXmlProperty(isAttribute = true)
    private Long id;
    private String name;
    private Long parentId;
    @JacksonXmlProperty(isAttribute = true)
    private String staticAttribute = "attr";
    private String staticTag = "tag";
    @JacksonXmlText
    private String staticText = "text";
}
