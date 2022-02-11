.DEFAULT_GOAL := png

PUML = plantuml -charset UTF-8
SOURCES := $(shell find * -type f -name "*.puml")
GENERATED := $(shell find * -type f -name "*.png")

PNGS = $(SOURCES:.puml=.png)

%.png: %.puml
	$(PUML) ./$<

clean:
	rm -rf $(PNGS) $(GENERATED)

testenv:
	$(PUML) -testdot

png: $(PNGS)
