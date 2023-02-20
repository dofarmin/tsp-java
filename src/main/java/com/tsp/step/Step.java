package com.tsp.step;

public class Step {
    private Integer id;
    private String description;

    private EdgeViewStep edgeStep;

    private VertexViewStep vertexStep;


    public Step(Integer id, String description) {
        this.id = id;
        this.description = description;

    }

    public Step(Integer id, String description,VertexViewStep vertexStep) {
        this.id = id;
        this.description = description;
        this.vertexStep = vertexStep;
    }

    public Step(Integer id, String description,EdgeViewStep edgeStep) {
        this.id = id;
        this.description = description;
        this.edgeStep = edgeStep;
    }

    public Step(Integer id, String description,VertexViewStep vertexStep,EdgeViewStep edgeStep) {
        this.id = id;
        this.description = description;
        this.vertexStep = vertexStep;
        this.edgeStep = edgeStep;
    }

    public String toString() {
        return "Step " + id + ": " + description;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EdgeViewStep getEdgeStep() {
        return edgeStep;
    }

    public VertexViewStep getVertexStep() {
        return vertexStep;
    }

}
