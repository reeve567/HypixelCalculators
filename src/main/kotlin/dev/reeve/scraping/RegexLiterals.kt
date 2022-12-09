package dev.reeve.scraping

object RegexLiterals {
	val minionLinkRegex = Regex("/wiki/(?<name>.+)_Minion")
	val minionIdRegex = Regex("<code>(?<id>.+?)_GENERATOR")
	val tableRegex = Regex("""<table class="wikitable">(.|\s)+?</table>""")
	val minionDropsRegex = RegexBuilder {
		add("<tr")
		// the first drop has these classes applied, but the rest don't
		addNonCapturingGroup(" class=\"${nonQuoteSelector}\"") // this is a group so that it can be optional
		add("?>")

		addWhiteSpaceSelector()

		// it either has this, none (which we want) or has a condition (which we don't want)
		// the named group `count` is so that we know how many drops to expect
		addNonCapturingGroup(
			"<td rowspan=\"${
				getNamedGroup(
					"count", "\\d+"
				)
			}\">None</td>"
		) // this is a group so that it can be optional
		add("?")

		addWhiteSpaceSelector()

		// they all have this
		add("""<td colspan="2" class="table-margin-off">""")
		addWhiteSpaceSelector()

		// they all have this
		add("""<table class="wikitable table-margin-off full-width smalltxt">""")
		addWhiteSpaceSelector()
		add("<tbody>")
		addWhiteSpaceSelector()
		add("""<tr>$whiteSpaceSelector<th colspan="2">From Harvest</th>$whiteSpaceSelector</tr>""")
		addWhiteSpaceSelector()

		// this is the start of useful information
		// average amount
		add(
			"<tr>$whiteSpaceSelector<td>Avg\\. Amount</td>$whiteSpaceSelector<td>${
				getNamedGroup("amount", "(?:0\\.)?\\d+")
			}</td>$whiteSpaceSelector</tr>"
		)
		addWhiteSpaceSelector()
		// chance, which could be in a couple different formats, so leaving that to code to handle
		add(
			"<tr>$whiteSpaceSelector<td>Chance${
				getNonCapturingGroup(getNonSelector("<").zeroOrMore())
			}</td>$whiteSpaceSelector<td>${
				getNamedGroup("chance", getNonSelector("<").zeroOrMore())
			}</td>$whiteSpaceSelector</tr>"
		)
		addWhiteSpaceSelector()
		add("</tbody>$whiteSpaceSelector</table>$whiteSpaceSelector</td>")

		addWhiteSpaceSelector()
		// this next part is just for display on the wiki, it isn't really important
		// TODO: Figure out why this causes a stack overflow
		add("""<td>(?:.|\s)+?</td>""")
		addWhiteSpaceSelector()

		// drop
		add(
			"""<td><a href="/wiki/${getNamedGroup("drop", nonQuoteSelector)}" title="${
				getNamedGroup(
					"dropName",
					nonQuoteSelector
				)
			}">"""
		)

		//TODO: could add in the info for XP, but that would make things even more complicated

	}.build().toRegex()
	// TODO: add npc price regex
}