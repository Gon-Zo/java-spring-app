import React from "react";
import { ResponsiveHeatMap } from '@nivo/heatmap'

export default () => {
    return (
        <Test data={data}/>
    )
}


function Test(props) {
    let data = props.data
    return(
        <ResponsiveHeatMap
            data={data}
            keys={[
                'hot dog',
                'burger',
                'sandwich',
                'kebab',
                'fries',
                'donut',
                'junk',
                'sushi',
                'ramen',
                'curry',
                'udon'
            ]}
            indexBy="country"
            margin={{ top: 100, right: 60, bottom: 60, left: 60 }}
            forceSquare={true}
            axisTop={{ orient: 'top', tickSize: 5, tickPadding: 5, tickRotation: -90, legend: '', legendOffset: 36 }}
            axisRight={null}
            axisBottom={null}
            axisLeft={{
                orient: 'left',
                tickSize: 5,
                tickPadding: 5,
                tickRotation: 0,
                legend: 'country',
                legendPosition: 'middle',
                legendOffset: -40
            }}
            cellOpacity={1}
            cellBorderColor={{ from: 'color', modifiers: [ [ 'darker', 0.4 ] ] }}
            labelTextColor={{ from: 'color', modifiers: [ [ 'darker', 1.8 ] ] }}
            defs={[
                {
                    id: 'lines',
                    type: 'patternLines',
                    background: 'inherit',
                    color: 'rgba(0, 0, 0, 0.1)',
                    rotation: -45,
                    lineWidth: 4,
                    spacing: 7
                }
            ]}
            fill={[ { id: 'lines' } ]}
            animate={true}
            motionStiffness={80}
            motionDamping={9}
            hoverTarget="cell"
            cellHoverOthersOpacity={0.25}
        />
    )
}

let data =

    [
        {
            "country": "AD",
            "hot dog": 30,
            "hot dogColor": "hsl(240, 70%, 50%)",
            "burger": 84,
            "burgerColor": "hsl(75, 70%, 50%)",
            "sandwich": 35,
            "sandwichColor": "hsl(76, 70%, 50%)",
            "kebab": 80,
            "kebabColor": "hsl(279, 70%, 50%)",
            "fries": 36,
            "friesColor": "hsl(52, 70%, 50%)",
            "donut": 62,
            "donutColor": "hsl(192, 70%, 50%)",
            "junk": 65,
            "junkColor": "hsl(215, 70%, 50%)",
            "sushi": 49,
            "sushiColor": "hsl(197, 70%, 50%)",
            "ramen": 49,
            "ramenColor": "hsl(360, 70%, 50%)",
            "curry": 71,
            "curryColor": "hsl(228, 70%, 50%)",
            "udon": 80,
            "udonColor": "hsl(81, 70%, 50%)"
        },
        {
            "country": "AE",
            "hot dog": 7,
            "hot dogColor": "hsl(158, 70%, 50%)",
            "burger": 31,
            "burgerColor": "hsl(316, 70%, 50%)",
            "sandwich": 56,
            "sandwichColor": "hsl(66, 70%, 50%)",
            "kebab": 65,
            "kebabColor": "hsl(358, 70%, 50%)",
            "fries": 64,
            "friesColor": "hsl(262, 70%, 50%)",
            "donut": 14,
            "donutColor": "hsl(230, 70%, 50%)",
            "junk": 72,
            "junkColor": "hsl(275, 70%, 50%)",
            "sushi": 90,
            "sushiColor": "hsl(0, 70%, 50%)",
            "ramen": 29,
            "ramenColor": "hsl(168, 70%, 50%)",
            "curry": 91,
            "curryColor": "hsl(66, 70%, 50%)",
            "udon": 7,
            "udonColor": "hsl(183, 70%, 50%)"
        },
        {
            "country": "AF",
            "hot dog": 24,
            "hot dogColor": "hsl(99, 70%, 50%)",
            "burger": 76,
            "burgerColor": "hsl(120, 70%, 50%)",
            "sandwich": 95,
            "sandwichColor": "hsl(296, 70%, 50%)",
            "kebab": 35,
            "kebabColor": "hsl(127, 70%, 50%)",
            "fries": 42,
            "friesColor": "hsl(45, 70%, 50%)",
            "donut": 9,
            "donutColor": "hsl(57, 70%, 50%)",
            "junk": 59,
            "junkColor": "hsl(143, 70%, 50%)",
            "sushi": 55,
            "sushiColor": "hsl(83, 70%, 50%)",
            "ramen": 80,
            "ramenColor": "hsl(214, 70%, 50%)",
            "curry": 47,
            "curryColor": "hsl(150, 70%, 50%)",
            "udon": 83,
            "udonColor": "hsl(131, 70%, 50%)"
        },
        {
            "country": "AG",
            "hot dog": 45,
            "hot dogColor": "hsl(324, 70%, 50%)",
            "burger": 65,
            "burgerColor": "hsl(24, 70%, 50%)",
            "sandwich": 54,
            "sandwichColor": "hsl(238, 70%, 50%)",
            "kebab": 38,
            "kebabColor": "hsl(271, 70%, 50%)",
            "fries": 25,
            "friesColor": "hsl(44, 70%, 50%)",
            "donut": 98,
            "donutColor": "hsl(72, 70%, 50%)",
            "junk": 56,
            "junkColor": "hsl(307, 70%, 50%)",
            "sushi": 61,
            "sushiColor": "hsl(282, 70%, 50%)",
            "ramen": 10,
            "ramenColor": "hsl(241, 70%, 50%)",
            "curry": 13,
            "curryColor": "hsl(39, 70%, 50%)",
            "udon": 91,
            "udonColor": "hsl(100, 70%, 50%)"
        },
        {
            "country": "AI",
            "hot dog": 15,
            "hot dogColor": "hsl(230, 70%, 50%)",
            "burger": 57,
            "burgerColor": "hsl(339, 70%, 50%)",
            "sandwich": 69,
            "sandwichColor": "hsl(223, 70%, 50%)",
            "kebab": 72,
            "kebabColor": "hsl(140, 70%, 50%)",
            "fries": 16,
            "friesColor": "hsl(35, 70%, 50%)",
            "donut": 37,
            "donutColor": "hsl(250, 70%, 50%)",
            "junk": 26,
            "junkColor": "hsl(72, 70%, 50%)",
            "sushi": 85,
            "sushiColor": "hsl(195, 70%, 50%)",
            "ramen": 46,
            "ramenColor": "hsl(96, 70%, 50%)",
            "curry": 20,
            "curryColor": "hsl(171, 70%, 50%)",
            "udon": 64,
            "udonColor": "hsl(301, 70%, 50%)"
        },
        {
            "country": "AL",
            "hot dog": 29,
            "hot dogColor": "hsl(108, 70%, 50%)",
            "burger": 74,
            "burgerColor": "hsl(232, 70%, 50%)",
            "sandwich": 77,
            "sandwichColor": "hsl(177, 70%, 50%)",
            "kebab": 56,
            "kebabColor": "hsl(32, 70%, 50%)",
            "fries": 76,
            "friesColor": "hsl(22, 70%, 50%)",
            "donut": 52,
            "donutColor": "hsl(329, 70%, 50%)",
            "junk": 18,
            "junkColor": "hsl(338, 70%, 50%)",
            "sushi": 93,
            "sushiColor": "hsl(353, 70%, 50%)",
            "ramen": 25,
            "ramenColor": "hsl(216, 70%, 50%)",
            "curry": 19,
            "curryColor": "hsl(58, 70%, 50%)",
            "udon": 21,
            "udonColor": "hsl(245, 70%, 50%)"
        },
        {
            "country": "AM",
            "hot dog": 16,
            "hot dogColor": "hsl(62, 70%, 50%)",
            "burger": 41,
            "burgerColor": "hsl(346, 70%, 50%)",
            "sandwich": 78,
            "sandwichColor": "hsl(157, 70%, 50%)",
            "kebab": 82,
            "kebabColor": "hsl(184, 70%, 50%)",
            "fries": 29,
            "friesColor": "hsl(328, 70%, 50%)",
            "donut": 10,
            "donutColor": "hsl(294, 70%, 50%)",
            "junk": 19,
            "junkColor": "hsl(206, 70%, 50%)",
            "sushi": 2,
            "sushiColor": "hsl(71, 70%, 50%)",
            "ramen": 88,
            "ramenColor": "hsl(85, 70%, 50%)",
            "curry": 48,
            "curryColor": "hsl(59, 70%, 50%)",
            "udon": 4,
            "udonColor": "hsl(79, 70%, 50%)"
        },
        {
            "country": "AO",
            "hot dog": 52,
            "hot dogColor": "hsl(261, 70%, 50%)",
            "burger": 76,
            "burgerColor": "hsl(137, 70%, 50%)",
            "sandwich": 77,
            "sandwichColor": "hsl(99, 70%, 50%)",
            "kebab": 82,
            "kebabColor": "hsl(7, 70%, 50%)",
            "fries": 22,
            "friesColor": "hsl(177, 70%, 50%)",
            "donut": 98,
            "donutColor": "hsl(32, 70%, 50%)",
            "junk": 56,
            "junkColor": "hsl(51, 70%, 50%)",
            "sushi": 84,
            "sushiColor": "hsl(346, 70%, 50%)",
            "ramen": 86,
            "ramenColor": "hsl(243, 70%, 50%)",
            "curry": 4,
            "curryColor": "hsl(136, 70%, 50%)",
            "udon": 52,
            "udonColor": "hsl(340, 70%, 50%)"
        },
        {
            "country": "AQ",
            "hot dog": 89,
            "hot dogColor": "hsl(56, 70%, 50%)",
            "burger": 96,
            "burgerColor": "hsl(112, 70%, 50%)",
            "sandwich": 99,
            "sandwichColor": "hsl(245, 70%, 50%)",
            "kebab": 91,
            "kebabColor": "hsl(6, 70%, 50%)",
            "fries": 40,
            "friesColor": "hsl(251, 70%, 50%)",
            "donut": 19,
            "donutColor": "hsl(115, 70%, 50%)",
            "junk": 74,
            "junkColor": "hsl(20, 70%, 50%)",
            "sushi": 100,
            "sushiColor": "hsl(232, 70%, 50%)",
            "ramen": 63,
            "ramenColor": "hsl(4, 70%, 50%)",
            "curry": 49,
            "curryColor": "hsl(67, 70%, 50%)",
            "udon": 59,
            "udonColor": "hsl(43, 70%, 50%)"
        }
    ]
