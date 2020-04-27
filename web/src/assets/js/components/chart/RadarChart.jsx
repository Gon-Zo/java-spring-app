import React from "react";
import { ResponsiveRadar } from '@nivo/radar'

export default () => {
    return (
        <Test data={data}/>
    )
}

function Test(props) {
    let data = props.data
    return (
        <ResponsiveRadar
            data={data}
            keys={['chardonay', 'carmenere', 'syrah']}
            indexBy="taste"
            maxValue="auto"
            margin={{top: 70, right: 80, bottom: 40, left: 80}}
            curve="linearClosed"
            borderWidth={2}
            borderColor={{from: 'color'}}
            gridLevels={5}
            gridShape="circular"
            gridLabelOffset={36}
            enableDots={true}
            dotSize={10}
            dotColor={{theme: 'background'}}
            dotBorderWidth={2}
            dotBorderColor={{from: 'color'}}
            enableDotLabel={true}
            dotLabel="value"
            dotLabelYOffset={-12}
            colors={{scheme: 'nivo'}}
            fillOpacity={0.25}
            blendMode="multiply"
            animate={true}
            motionStiffness={90}
            motionDamping={15}
            isInteractive={true}
            legends={[
                {
                    anchor: 'top-left',
                    direction: 'column',
                    translateX: -50,
                    translateY: -40,
                    itemWidth: 80,
                    itemHeight: 20,
                    itemTextColor: '#999',
                    symbolSize: 12,
                    symbolShape: 'circle',
                    effects: [
                        {
                            on: 'hover',
                            style: {
                                itemTextColor: '#000'
                            }
                        }
                    ]
                }
            ]}
        />
    )
}

let data =
    [
        {
            "taste": "fruity",
            "chardonay": 113,
            "carmenere": 68,
            "syrah": 45
        },
        {
            "taste": "bitter",
            "chardonay": 46,
            "carmenere": 88,
            "syrah": 79
        },
        {
            "taste": "heavy",
            "chardonay": 116,
            "carmenere": 103,
            "syrah": 53
        },
        {
            "taste": "strong",
            "chardonay": 114,
            "carmenere": 41,
            "syrah": 30
        },
        {
            "taste": "sunny",
            "chardonay": 27,
            "carmenere": 24,
            "syrah": 77
        }
    ]
