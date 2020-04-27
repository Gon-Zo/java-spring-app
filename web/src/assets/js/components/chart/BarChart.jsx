import React from "react";
import { ResponsiveBar } from '@nivo/bar'

export default () =>{
    return(
        <Test2 data={data}/>
    )
}

function Test2(props) {

    let data = props.data

    return(
        <ResponsiveBar
            data={data}
            keys={[ 'hot dog', 'burger', 'sandwich', 'kebab', 'fries', 'donut' ]}
            indexBy="country"
            margin={{ top: 10, right: 110, bottom: 50, left: 60 }}
            padding={0.3}
            colors={{ scheme: 'dark2' }}
            defs={[
                {
                    id: 'dots',
                    type: 'patternDots',
                    background: 'inherit',
                    color: '#38bcb2',
                    size: 4,
                    padding: 1,
                    stagger: true
                },
                {
                    id: 'lines',
                    type: 'patternLines',
                    background: 'inherit',
                    color: '#eed312',
                    rotation: -45,
                    lineWidth: 6,
                    spacing: 10
                }
            ]}
            fill={[
                {
                    match: {
                        id: 'fries'
                    },
                    id: 'dots'
                },
                {
                    match: {
                        id: 'sandwich'
                    },
                    id: 'lines'
                }
            ]}
            borderColor={{ from: 'color', modifiers: [ [ 'darker', 1.6 ] ] }}
            axisTop={null}
            axisRight={null}
            axisBottom={{
                tickSize: 5,
                tickPadding: 5,
                tickRotation: 0,
                legend: 'country',
                legendPosition: 'middle',
                legendOffset: 32
            }}
            axisLeft={{
                tickSize: 5,
                tickPadding: 5,
                tickRotation: 0,
                legend: 'food',
                legendPosition: 'middle',
                legendOffset: -40
            }}
            labelSkipWidth={12}
            labelSkipHeight={12}
            labelTextColor={{ from: 'background', modifiers: [ [ 'darker', 1.6 ] ] }}
            legends={[
                {
                    dataFrom: 'keys',
                    anchor: 'bottom-right',
                    direction: 'column',
                    justify: false,
                    translateX: 120,
                    translateY: 0,
                    itemsSpacing: 2,
                    itemWidth: 100,
                    itemHeight: 20,
                    itemDirection: 'left-to-right',
                    itemOpacity: 0.85,
                    symbolSize: 20,
                    effects: [
                        {
                            on: 'hover',
                            style: {
                                itemOpacity: 1
                            }
                        }
                    ]
                }
            ]}
            animate={true}
            motionStiffness={90}
            motionDamping={15}
        />
    )
}

let data = [
    {
        "country": "AD",
        "hot dog": 13,
        "hot dogColor": "hsl(143, 70%, 50%)",
        "burger": 14,
        "burgerColor": "hsl(55, 70%, 50%)",
        "sandwich": 116,
        "sandwichColor": "hsl(114, 70%, 50%)",
        "kebab": 140,
        "kebabColor": "hsl(277, 70%, 50%)",
        "fries": 186,
        "friesColor": "hsl(140, 70%, 50%)",
        "donut": 41,
        "donutColor": "hsl(186, 70%, 50%)"
    },
    {
        "country": "AE",
        "hot dog": 159,
        "hot dogColor": "hsl(176, 70%, 50%)",
        "burger": 74,
        "burgerColor": "hsl(241, 70%, 50%)",
        "sandwich": 146,
        "sandwichColor": "hsl(5, 70%, 50%)",
        "kebab": 93,
        "kebabColor": "hsl(56, 70%, 50%)",
        "fries": 131,
        "friesColor": "hsl(349, 70%, 50%)",
        "donut": 82,
        "donutColor": "hsl(211, 70%, 50%)"
    },
    {
        "country": "AF",
        "hot dog": 187,
        "hot dogColor": "hsl(281, 70%, 50%)",
        "burger": 94,
        "burgerColor": "hsl(80, 70%, 50%)",
        "sandwich": 76,
        "sandwichColor": "hsl(48, 70%, 50%)",
        "kebab": 181,
        "kebabColor": "hsl(65, 70%, 50%)",
        "fries": 126,
        "friesColor": "hsl(122, 70%, 50%)",
        "donut": 92,
        "donutColor": "hsl(129, 70%, 50%)"
    },
    {
        "country": "AG",
        "hot dog": 9,
        "hot dogColor": "hsl(318, 70%, 50%)",
        "burger": 81,
        "burgerColor": "hsl(266, 70%, 50%)",
        "sandwich": 71,
        "sandwichColor": "hsl(300, 70%, 50%)",
        "kebab": 91,
        "kebabColor": "hsl(350, 70%, 50%)",
        "fries": 63,
        "friesColor": "hsl(47, 70%, 50%)",
        "donut": 189,
        "donutColor": "hsl(224, 70%, 50%)"
    },
    {
        "country": "AI",
        "hot dog": 188,
        "hot dogColor": "hsl(197, 70%, 50%)",
        "burger": 146,
        "burgerColor": "hsl(178, 70%, 50%)",
        "sandwich": 0,
        "sandwichColor": "hsl(130, 70%, 50%)",
        "kebab": 141,
        "kebabColor": "hsl(224, 70%, 50%)",
        "fries": 76,
        "friesColor": "hsl(97, 70%, 50%)",
        "donut": 133,
        "donutColor": "hsl(285, 70%, 50%)"
    },
    {
        "country": "AL",
        "hot dog": 176,
        "hot dogColor": "hsl(184, 70%, 50%)",
        "burger": 120,
        "burgerColor": "hsl(144, 70%, 50%)",
        "sandwich": 74,
        "sandwichColor": "hsl(65, 70%, 50%)",
        "kebab": 173,
        "kebabColor": "hsl(207, 70%, 50%)",
        "fries": 143,
        "friesColor": "hsl(141, 70%, 50%)",
        "donut": 185,
        "donutColor": "hsl(345, 70%, 50%)"
    },
    {
        "country": "AM",
        "hot dog": 170,
        "hot dogColor": "hsl(245, 70%, 50%)",
        "burger": 51,
        "burgerColor": "hsl(87, 70%, 50%)",
        "sandwich": 173,
        "sandwichColor": "hsl(6, 70%, 50%)",
        "kebab": 59,
        "kebabColor": "hsl(81, 70%, 50%)",
        "fries": 91,
        "friesColor": "hsl(25, 70%, 50%)",
        "donut": 174,
        "donutColor": "hsl(331, 70%, 50%)"
    }
]
