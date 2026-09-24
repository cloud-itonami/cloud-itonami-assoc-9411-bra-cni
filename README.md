# cloud-itonami-assoc-9411-bra-cni

Industry rule/history catalog for the **National Confederation of
Industry** (Confederação Nacional da Indústria, CNI) — the EIGHTH
entry aligned to **ISIC 9411** (activities of business, employers, and
professional membership organizations), alongside
[`-9411-sau-fsc`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-sau-fsc)
(Saudi Arabia),
[`-9411-aut-wko`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-aut-wko)
(Austria),
[`-9411-irl-ibec`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-irl-ibec)
(Ireland),
[`-9411-nzl-businessnz`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-nzl-businessnz)
(New Zealand),
[`-9411-cze-spcr`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-cze-spcr)
(Czech Republic),
[`-9411-ind-cii`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-ind-cii)
(India), and
[`-9411-zaf-busa`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-zaf-busa)
(South Africa). Part of the
[`cloud-itonami`](https://github.com/cloud-itonami) compliance-fact
family (ADR-2607141700, `cloud-itonami-compliance-fact-federation`,
in `com-junkawasaki/root`).

## Sourcing note

This repo fills Brazil's previously-open association-axis gap (one of
the 20-country gap list recorded at tick 142). Brazil now has real,
individually verified facts across all three axes: country
([`cloud-itonami-iso3166-bra`](https://github.com/cloud-itonami/cloud-itonami-iso3166-bra)),
municipality
([`cloud-itonami-municipality-bra-sao-paulo`](https://github.com/cloud-itonami/cloud-itonami-municipality-bra-sao-paulo)),
and association (this repo).

The 30 entries cite two speakers, declared per entry by
`:url-provenance`:

- **CNI itself** (`:official-cni-portaldaindustria`) — the
  institutional pages on `cni.portaldaindustria.com.br` (Institucional,
  Sistema Confederativo, Fóruns e Conselhos, Programa de Compliance) and
  CNI's statute, a PDF served from the same site
  (`documents/d/cni/estatuto_da_cni`). The statute dates CNI's founding
  (12 August 1938), its ministerial recognition (17 September 1938), the
  decree that ratified it (30 April 1943), its own approval (2008) and
  its latest amendment (29 June 2021).
- **FGV CPDOC** (`:fgv-cpdoc-corroborated`) — the historical dictionary
  entry on CNI, for the history CNI's own pages do not narrate: the
  1933 predecessor, the 1939 corporatist decree, SENAI (1942) and SESI
  (1946).

Both speakers give the 12 August 1938 founding; both are kept, as two
entries. Each entry carries the verbatim Portuguese span it rests on
(`:source-quote`), taken from the page body rather than the header,
the repeated SENAI banner or the footer. Figures CNI gives about itself
(27 federations, more than 1,350 unions, more than 70 association
presidents in the FNI) are recorded as what CNI states. Pages that name
office-holders (the compliance page's presidential message, the
council chairs, past presidents in the FGV entry) are quoted only up to
the name; no name is persisted.

No dedicated Wikidata "inception" statement exists for CNI (Q1125075
has no such property) — noted transparently rather than fabricated.

## Scope

A **read-only reference/archive** catalog — not an Advisor⊣Governor
actuation actor. It proposes or executes nothing on CNI's behalf.

Coverage is reported honestly (see `association.facts/coverage`): an
association not in `catalog` has **no spec-basis**, full stop — never
fabricate one.

## Data

- `data/datascript-tx.edn` — the catalog. The facts are authored here
  and nowhere else.
- `src/association/facts.kotoba` (Clojure reading) and
  `src/association_facts.kotoba` (Kotoba port) — both GENERATED from the
  data file; do not hand-edit.
- `schema/association-rule.edn` — DataScript schema.

Query it alongside other `cloud-itonami`/`etzhayyim` compliance-fact
sources via `com-junkawasaki/root`'s `scripts/compliance-fact-query.cljs`.

## Verify

```bash
kbb --backend sci scripts/gen-kotoba-port.cljk --check    # both readings match the data file
kbb --backend sci scripts/verify-catalog.cljk             # structural, offline
kbb --backend sci scripts/verify-catalog.cljk --live      # fetch every :url, require every quote
```

`verify-catalog` exits 0 (checked, nothing wrong), 1 (findings printed)
or 2 (REFUSED: it could not read the catalog or a source, which is
neither a pass nor a finding). Dates are checked in the Portuguese the
sources write them in (`12 de agosto de 1938`, `1º de julho de 1946`).
`--live` needs `curl` and, for the statute PDF, `pdftotext`.

## License

AGPL-3.0-or-later (matches the `cloud-itonami-iso3166-*` /
`-municipality-*` / `-assoc-*` / `-lei-*` convention). Policy text
itself remains CNI's (and FGV's); this repo stores only citation
metadata (id/title/url/dates) and the short verbatim span each claim
rests on, not full text.
