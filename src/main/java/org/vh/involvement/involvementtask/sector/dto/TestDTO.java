package org.vh.involvement.involvementtask.sector.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "test")
public class TestDTO {
    @JacksonXmlProperty(isAttribute = true)
    private String staticAttribute = "attr";
    private String staticTag = "tag";
    @JacksonXmlText
    private String staticText = "text";
}
