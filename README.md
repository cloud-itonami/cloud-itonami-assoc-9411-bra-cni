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

`cni.portaldaindustria.com.br`'s own institutional page renders
successfully but does not surface founding-history detail on the page
checked. Both entries here were instead directly WebFetch-verified
against the FGV CPDOC (Centro de Pesquisa e Documentação de História
Contemporânea do Brasil, part of Fundação Getulio Vargas — a leading
Brazilian academic archive of contemporary history) historical
dictionary entry. No dedicated Wikidata "inception" statement exists
for CNI (Q1125075 has no such property) — noted transparently rather
than fabricated.

## Scope

A **read-only reference/archive** catalog — not an Advisor⊣Governor
actuation actor. It proposes or executes nothing on CNI's behalf.

Coverage is reported honestly (see `association.facts/coverage`): an
association not in `catalog` has **no spec-basis**, full stop — never
fabricate one.

## Data

- `src/association/facts.cljc` — the catalog, source of truth.
- `schema/association-rule.edn` — DataScript schema.
- `data/datascript-tx.edn` — derived DataScript tx-data (query this
  alongside other `cloud-itonami`/`etzhayyim` compliance-fact sources via
  `com-junkawasaki/root`'s `scripts/compliance-fact-query.cljs`).

Both entries directly WebFetch-verified against FGV CPDOC's own
historical dictionary: the 25 January 1933 founding of the
Confederação Industrial do Brasil (CIB, CNI's direct predecessor) in
Rio de Janeiro, and the 12 August 1938 creation of the Confederação
Nacional da Indústria (CNI) itself, recognized by the Brazilian
Ministry of Labor, Industry and Commerce on 17 September 1938.

## License

AGPL-3.0-or-later (matches the `cloud-itonami-iso3166-*` /
`-municipality-*` / `-assoc-*` / `-lei-*` convention). Policy text
itself remains CNI's; this repo stores only citation metadata
(id/title/url/dates), not full text.
